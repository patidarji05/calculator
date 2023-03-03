import styled from "styled-components";

export const Container = styled.div`
  display: grid;
  justify-content: center;
  align-content: center;
  margin: 40px auto;
  grid-template-columns: repeat(4, 100px);
  grid-template-rows: minmax(120px, auto) repeat(5, 100px);
  box-shadow: 2px 2px 10px #333;
  border-radius: 10px;

   width: 500px;
  height:840px;
  padding: 10px;
  border-radius: 10px;

  background-color: #485461;
  background-image: linear-gradient(315deg, #485461 0%, #28313b 74%);
  
`;

export const Screen = styled.div`
   
  grid-column: 1 / -1;
  flex-direction: column;
  word-wrap: break-word;
  word-break: break-all;
  text-align: right;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
margin-top:10px;
margin-align:center;

margin-right:30px;
  height: 90px;
  width: 100%;
  margin-bottom: 10px;
  padding: 0 10px;
  background-color: #4357692d;
  border-radius: 10px;
  display: flex;
  
  justify-content: flex-end;
  color: white;
  font-weight: bold;
  box-sizing: border-box;
`;

export const Prevoius = styled.div`
  color: rgba(255, 255, 255, 0.75);
  font-size: 1.0rem;
   padding-block-start: 2rem;
    padding-inline-end: 1.25rem;
`;

export const Current = styled.div`
  color: white;
  font-size: 1.5rem;
 
`;

export const Button = styled.button`

cursor: pointer;
  font-size: 2rem;
border:none
 background: hsl(210, 25%, 95%);
    inline-size: 90px;
  block-size: 90px;
  border-radius: 60px;
 ${'' /* background-color: rgba(255, 255, 255, 0.75); */}
  b background: hsl(255, 100%, 100%);
  &:hover {
    background-color: rgba(255, 255, 255, 0.9);
  }

${({ del }) => del && `background-color:red;`};
 ${({ operation }) => operation && `background-color:gray;`};
  ${({ control }) => control && `background-color:skyBlue;`};
  
  ${({ equals }) =>
    equals && `background-color:gray;
    border-bottom-right-radius:700px;
    inline-size: 300px;
  block-size: 80px;
  border-radius: 0px;
        
    `};
    
         ${({ decimal }) =>
    decimal && `background-color:white;`};
`;
