package com.ecommerce.blockchain.domain.contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class ERC721 extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506100437f01ffc9a70000000000000000000000000000000000000000000000000000000064010000000061008c810204565b6100757f80ac58cd0000000000000000000000000000000000000000000000000000000064010000000061008c810204565b60068054600160a060020a0319163317905561015a565b7fffffffff00000000000000000000000000000000000000000000000000000000808216141561011d57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601c60248201527f4552433136353a20696e76616c696420696e7465726661636520696400000000604482015290519081900360640190fd5b7fffffffff00000000000000000000000000000000000000000000000000000000166000908152602081905260409020805460ff19166001179055565b611801806101696000396000f3fe6080604052600436106100c45763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166301ffc9a781146100c9578063081812fc14610126578063095ea7b31461016c57806323b872dd146101a757806342842e0e146101ea5780636352211e1461022d5780636f185be01461025757806370a082311461042b5780638da5cb5b14610470578063a22cb46514610485578063b88d4fde146104c0578063bfb231d214610593578063e985e9c514610708575b600080fd5b3480156100d557600080fd5b50610112600480360360208110156100ec57600080fd5b50357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916610743565b604080519115158252519081900360200190f35b34801561013257600080fd5b506101506004803603602081101561014957600080fd5b5035610777565b60408051600160a060020a039092168252519081900360200190f35b34801561017857600080fd5b506101a56004803603604081101561018f57600080fd5b50600160a060020a03813516906020013561081a565b005b3480156101b357600080fd5b506101a5600480360360608110156101ca57600080fd5b50600160a060020a03813581169160208101359091169060400135610a72565b3480156101f657600080fd5b506101a56004803603606081101561020d57600080fd5b50600160a060020a03813581169160208101359091169060400135610b08565b34801561023957600080fd5b506101506004803603602081101561025057600080fd5b5035610b24565b34801561026357600080fd5b506101a5600480360360a081101561027a57600080fd5b81019060208101813564010000000081111561029557600080fd5b8201836020820111156102a757600080fd5b803590602001918460018302840111640100000000831117156102c957600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295600160a060020a0385351695909490935060408101925060200135905064010000000081111561032d57600080fd5b82018360208201111561033f57600080fd5b8035906020019184600183028401116401000000008311171561036157600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092959493602081019350359150506401000000008111156103b457600080fd5b8201836020820111156103c657600080fd5b803590602001918460018302840111640100000000831117156103e857600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505091359250610bbf915050565b34801561043757600080fd5b5061045e6004803603602081101561044e57600080fd5b5035600160a060020a0316610c9b565b60408051918252519081900360200190f35b34801561047c57600080fd5b50610150610d44565b34801561049157600080fd5b506101a5600480360360408110156104a857600080fd5b50600160a060020a0381351690602001351515610d53565b3480156104cc57600080fd5b506101a5600480360360808110156104e357600080fd5b600160a060020a0382358116926020810135909116916040820135919081019060808101606082013564010000000081111561051e57600080fd5b82018360208201111561053057600080fd5b8035906020019184600183028401116401000000008311171561055257600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610e22945050505050565b34801561059f57600080fd5b506105bd600480360360208110156105b657600080fd5b5035610ebb565b60405180806020018060200180602001858152602001848103845288818151815260200191508051906020019080838360005b838110156106085781810151838201526020016105f0565b50505050905090810190601f1680156106355780820380516001836020036101000a031916815260200191505b50848103835287518152875160209182019189019080838360005b83811015610668578181015183820152602001610650565b50505050905090810190601f1680156106955780820380516001836020036101000a031916815260200191505b50848103825286518152865160209182019188019080838360005b838110156106c85781810151838201526020016106b0565b50505050905090810190601f1680156106f55780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b34801561071457600080fd5b506101126004803603604081101561072b57600080fd5b50600160a060020a03813581169160200135166110a2565b7bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191660009081526020819052604090205460ff1690565b6000610782826110d0565b15156107fe576040805160e560020a62461bcd02815260206004820152602c60248201527f4552433732313a20617070726f76656420717565727920666f72206e6f6e657860448201527f697374656e7420746f6b656e0000000000000000000000000000000000000000606482015290519081900360840190fd5b50600090815260026020526040902054600160a060020a031690565b600061082582610b24565b9050600160a060020a0383811690821614156108b1576040805160e560020a62461bcd02815260206004820152602160248201527f4552433732313a20617070726f76616c20746f2063757272656e74206f776e6560448201527f7200000000000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b33600160a060020a0382161461095d576040805160e560020a62461bcd02815260206004820152604560248201527f4552433732313a20617070726f76652063616c6c6572206973206e6f74206f7760448201527f6e6572206e6f7220617070726f76656420666f7220616c6c313131313131313160648201527f3131313131000000000000000000000000000000000000000000000000000000608482015290519081900360a40190fd5b61096781336110a2565b1515610a09576040805160e560020a62461bcd02815260206004820152604560248201527f4552433732313a20617070726f76652063616c6c6572206973206e6f74206f7760448201527f6e6572206e6f7220617070726f76656420666f7220616c6c323232323232323260648201527f3232323232000000000000000000000000000000000000000000000000000000608482015290519081900360a40190fd5b600082815260026020526040808220805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0387811691821790925591518593918516917f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92591a4505050565b610a7c33826110ed565b1515610af8576040805160e560020a62461bcd02815260206004820152603160248201527f4552433732313a207472616e736665722063616c6c6572206973206e6f74206f60448201527f776e6572206e6f7220617070726f766564000000000000000000000000000000606482015290519081900360840190fd5b610b038383836111d2565b505050565b610b038383836020604051908101604052806000815250610e22565b600081815260016020526040812054600160a060020a0316801515610bb9576040805160e560020a62461bcd02815260206004820152602960248201527f4552433732313a206f776e657220717565727920666f72206e6f6e657869737460448201527f656e7420746f6b656e0000000000000000000000000000000000000000000000606482015290519081900360840190fd5b92915050565b600654600160a060020a03163314610bd657600080fd5b600580546040805160808101825288815260208082018890529181018690526060810185905260018301808555600094909452805180519394939192600486027f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db00192610c46928492019061173a565b506020828101518051610c5f926001850192019061173a565b5060408201518051610c7b91600284019160209091019061173a565b5060608201518160030155505050610c9385826113a2565b505050505050565b6000600160a060020a0382161515610d23576040805160e560020a62461bcd02815260206004820152602a60248201527f4552433732313a2062616c616e636520717565727920666f7220746865207a6560448201527f726f206164647265737300000000000000000000000000000000000000000000606482015290519081900360840190fd5b600160a060020a0382166000908152600360205260409020610bb9906114e8565b600654600160a060020a031681565b600160a060020a038216331415610db4576040805160e560020a62461bcd02815260206004820152601960248201527f4552433732313a20617070726f766520746f2063616c6c657200000000000000604482015290519081900360640190fd5b336000818152600460209081526040808320600160a060020a03871680855290835292819020805460ff1916861515908117909155815190815290519293927f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31929181900390910190a35050565b610e2d848484610a72565b610e39848484846114ec565b1515610eb5576040805160e560020a62461bcd02815260206004820152603260248201527f4552433732313a207472616e7366657220746f206e6f6e20455243373231526560448201527f63656976657220696d706c656d656e7465720000000000000000000000000000606482015290519081900360840190fd5b50505050565b6005805482908110610ec957fe5b60009182526020918290206004919091020180546040805160026001841615610100026000190190931692909204601f810185900485028301850190915280825291935091839190830182828015610f625780601f10610f3757610100808354040283529160200191610f62565b820191906000526020600020905b815481529060010190602001808311610f4557829003601f168201915b505050505090806001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110005780601f10610fd557610100808354040283529160200191611000565b820191906000526020600020905b815481529060010190602001808311610fe357829003601f168201915b50505060028085018054604080516020601f60001961010060018716150201909416959095049283018590048502810185019091528181529596959450909250908301828280156110925780601f1061106757610100808354040283529160200191611092565b820191906000526020600020905b81548152906001019060200180831161107557829003601f168201915b5050505050908060030154905084565b600160a060020a03918216600090815260046020908152604080832093909416825291909152205460ff1690565b600090815260016020526040902054600160a060020a0316151590565b60006110f8826110d0565b1515611174576040805160e560020a62461bcd02815260206004820152602c60248201527f4552433732313a206f70657261746f7220717565727920666f72206e6f6e657860448201527f697374656e7420746f6b656e0000000000000000000000000000000000000000606482015290519081900360840190fd5b600061117f83610b24565b905080600160a060020a031684600160a060020a031614806111ba575083600160a060020a03166111af84610777565b600160a060020a0316145b806111ca57506111ca81856110a2565b949350505050565b82600160a060020a03166111e582610b24565b600160a060020a031614611269576040805160e560020a62461bcd02815260206004820152602960248201527f4552433732313a207472616e73666572206f6620746f6b656e2074686174206960448201527f73206e6f74206f776e0000000000000000000000000000000000000000000000606482015290519081900360840190fd5b600160a060020a03821615156112ee576040805160e560020a62461bcd028152602060048201526024808201527f4552433732313a207472616e7366657220746f20746865207a65726f2061646460448201527f7265737300000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b6112f781611668565b600160a060020a0383166000908152600360205260409020611318906116b2565b600160a060020a0382166000908152600360205260409020611339906116c9565b600081815260016020526040808220805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0386811691821790925591518493918716917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef91a4505050565b600160a060020a0382161515611402576040805160e560020a62461bcd02815260206004820181905260248201527f4552433732313a206d696e7420746f20746865207a65726f2061646472657373604482015290519081900360640190fd5b61140b816110d0565b15611460576040805160e560020a62461bcd02815260206004820152601c60248201527f4552433732313a20746f6b656e20616c7265616479206d696e74656400000000604482015290519081900360640190fd5b6000818152600160209081526040808320805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0387169081179091558352600390915290206114ac906116c9565b6040518190600160a060020a038416906000907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef908290a45050565b5490565b600061150084600160a060020a03166116d2565b151561150e575060016111ca565b6040517f150b7a020000000000000000000000000000000000000000000000000000000081523360048201818152600160a060020a03888116602485015260448401879052608060648501908152865160848601528651600095928a169463150b7a029490938c938b938b939260a4019060208501908083838e5b838110156115a1578181015183820152602001611589565b50505050905090810190601f1680156115ce5780820380516001836020036101000a031916815260200191505b5095505050505050602060405180830381600087803b1580156115f057600080fd5b505af1158015611604573d6000803e3d6000fd5b505050506040513d602081101561161a57600080fd5b50517bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167f150b7a020000000000000000000000000000000000000000000000000000000014915050949350505050565b600081815260026020526040902054600160a060020a0316156116af576000818152600260205260409020805473ffffffffffffffffffffffffffffffffffffffff191690555b50565b80546116c590600163ffffffff6116da16565b9055565b80546001019055565b6000903b1190565b600082821115611734576040805160e560020a62461bcd02815260206004820152601e60248201527f536166654d6174683a207375627472616374696f6e206f766572666c6f770000604482015290519081900360640190fd5b50900390565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061177b57805160ff19168380011785556117a8565b828001600101855582156117a8579182015b828111156117a857825182559160200191906001019061178d565b506117b49291506117b8565b5090565b6117d291905b808211156117b457600081556001016117be565b9056fea165627a7a7230582049d9b044adbce57a75dfe0c76e619cd8fae73704660460db13fc68851204f8a20029";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_GETAPPROVED = "getApproved";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_safeTransferFrom = "safeTransferFrom";

    public static final String FUNC_OWNEROF = "ownerOf";

    public static final String FUNC_MINTIMAGE = "mintImage";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_ITEMS = "items";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    @Deprecated
    protected ERC721(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC721(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC721(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC721(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final Function function = new Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> getApproved(BigInteger tokenId) {
        final Function function = new Function(FUNC_GETAPPROVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String to, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> ownerOf(BigInteger tokenId) {
        final Function function = new Function(FUNC_OWNEROF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> mintImage(String name, String account, String imageurl, String explanation, BigInteger category) {
        final Function function = new Function(
                FUNC_MINTIMAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.Utf8String(imageurl), 
                new org.web3j.abi.datatypes.Utf8String(explanation), 
                new org.web3j.abi.datatypes.generated.Uint256(category)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String owner) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setApprovalForAll(String to, Boolean approved) {
        final Function function = new Function(
                FUNC_SETAPPROVALFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.Bool(approved)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId, byte[] _data) {
        final Function function = new Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple4<String, String, String, BigInteger>> items(BigInteger param0) {
        final Function function = new Function(FUNC_ITEMS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<String, String, String, BigInteger>>(function,
                new Callable<Tuple4<String, String, String, BigInteger>>() {
                    @Override
                    public Tuple4<String, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Boolean> isApprovedForAll(String owner, String operator) {
        final Function function = new Function(FUNC_ISAPPROVEDFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, operator)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public List<ApprovalForAllEventResponse> getApprovalForAllEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVALFORALL_EVENT, transactionReceipt);
        ArrayList<ApprovalForAllEventResponse> responses = new ArrayList<ApprovalForAllEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ApprovalForAllEventResponse>() {
            @Override
            public ApprovalForAllEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVALFORALL_EVENT, log);
                ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVALFORALL_EVENT));
        return approvalForAllEventFlowable(filter);
    }

    @Deprecated
    public static ERC721 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC721(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC721 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC721(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC721 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC721(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC721 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC721(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC721> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ERC721.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<ERC721> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ERC721.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ERC721> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ERC721.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ERC721> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ERC721.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger tokenId;
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String approved;

        public BigInteger tokenId;
    }

    public static class ApprovalForAllEventResponse extends BaseEventResponse {
        public String owner;

        public String operator;

        public Boolean approved;
    }
}
