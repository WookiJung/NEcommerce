import React, { useEffect, useState } from "react";
import axios from "axios";
import { Table, Image } from "react-bootstrap";
import { Link } from "react-router-dom";
import GetUserPK from "../assets/GetUserPK";
const OwningNFT = (props) => {
    const [loading, setLoading] = useState(true)
    const [MyNFT, setMyNFT] = useState([])

    useEffect(() => {
        const fetchData = async () => {
          const userPK = GetUserPK()
          console.log(userPK)
          const result = await axios.get(
            `api/v1/nft/list/${userPK}`,
          );
          setMyNFT(result.data);
          setLoading(false);
        };
        fetchData();
      }, []);
    
    const showAsTable = (NFT) => {
      return (
      <tbody>

        <tr>
          <Link to={`/detail/${NFT.NFTid}`}>
            <Image src={NFT.ImageUrl}/>
          </Link> 
        </tr>
        <tr>
          <p>{NFT.Title} </p>

        </tr>
      </tbody>)
    }

    return(
        <>
          {loading ? (
            <div>
              Loading...
            </div>
          ) : (
            <Table>
              <thead>
                <th>이미지</th>
                <th>제목</th>
              </thead>
              {MyNFT.map(showAsTable)}
            </Table>
            
          )}
        </>
    )
}

export default OwningNFT