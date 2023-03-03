import React, { useState } from "react";
import { Container, Screen, Prevoius, Current, Button } from './main';
import axios from "axios";
import base_url from "../api/bootapi";

const Calculator = () => {
    const [current, setCurrent] = useState("");
    const [prevoius, setPrevoius] = useState("");
    const [operations, setOperations] = useState("");
    const [result, setResult] = useState("");

    const appendValueHandler = (el) => {
        console.log("btn click")
        const value = el.target.getAttribute("data");//8+8+
        if (value === "." && current.includes(".")) return;
        console.log("valuesa" + (current + value))
        setCurrent(current + value);
    };

    const deleteHandler = () => {
        setCurrent(String(current).slice(0, -1));
    };

    const allclearHandler = () => {
        setCurrent("");
        setOperations("");
        setPrevoius("");
        //  setResult("");
    };


    const chooseOperationHandler = (el) => {
        console.log("calling...");
        if (current === "") return;
        if (prevoius !== "") {
            let value = compute();
            setPrevoius(value);
        } else {
            setPrevoius(current);
        }
        setCurrent("");
        console.log("el....el" + el.target.getAttribute("data"))
        setOperations(el.target.getAttribute("data"));
        if (current !== "" && prevoius !== "") {
            equalHandler();

        }
    };


    const memoryoperation = async (el) => {

        let currentNumber = parseFloat(current);
        console.log(el.target.getAttribute("data"))

        if (el.target.getAttribute("data") === "m+" || el.target.getAttribute("data") === "m-") {
            if (isNaN(currentNumber)) return;
        }

        switch (el.target.getAttribute("data")) {
            case "m+":

                await axios.post(`${base_url}mplus/${currentNumber}`);
                setPrevoius(currentNumber);
                setCurrent("");
                break;
            case "m-":

                await axios.post(`${base_url}mminus/-${currentNumber}`);
                setPrevoius(currentNumber);
                setCurrent("");
                break;
            case "mr":
                console.log("inside the mr")
                const res3 = await axios.get(`${base_url}mr`);
                console.log("ResultFromAddition===========>", res3)
                console.log(res3.data.toString());
                setCurrent(res3.data.toString());
                setPrevoius("   ")
                break;
            case "mc":
                const res4 = await axios.get(`${base_url}mc`);
                console.log("ResultFromAddition===========>", res4)
                setCurrent(res4.data.toString());
                setPrevoius("");
                break;
            default:
                return;
        }
    }

    const mathemeticaoperation = async (el) => {

        let currentNumber = parseFloat(current);

        if (isNaN(currentNumber)) return;

        switch (el.target.getAttribute("data")) {
            case "1/x":
                console.log("inside the mr")
                const res3 = await axios.get(`${base_url}derivative/${currentNumber}`);
                console.log("ResultFromAddition===========>", res3)
                console.log(res3.data.toString());
                setCurrent(res3.data.toString());
                break;
            case "x²":
                const res4 = await axios.get(`${base_url}power/${currentNumber}`);
                console.log("ResultFromAddition===========>", res4)
                setCurrent(res4.data.toString());
                break;
            case "√x":
                const res1 = await axios.get(`${base_url}sqrroot/${currentNumber}`);
                console.log("ResultFromAddition===========>", res1)
                setCurrent(res1.data.toString());
                break;
            default:
                return;
        }

    }


    const equalHandler = () => {
        let value = compute();
        console.log(`value is ${value}`)
        if (value === undefined || value == null) return;
        // setCurrent(value);
        console.log(`value curent ${setCurrent}`)
        setPrevoius("");
        setOperations("");
    };

    const compute = async () => {
        // let result=parseFloat(result1);
        console.log(`operation value is ...${operations}`)
        console.log(`prevoius value is ...${prevoius}`)
        let previousNumber = parseFloat(prevoius);
        console.log(`current value is ...${current}`)
        let currentNumber = parseFloat(current);
        if (isNaN(previousNumber) || isNaN(currentNumber)) return;



        // console.log(`;.;.;.;. ${result}`)
        switch (operations) {
            case "÷":
                // result = previousNumber / currentNumber;
                // axios.get(`${base_url}div/${previousNumber}/${currentNumber}`).then(

                //     (res) => {

                //         // setResult(res.data);
                //         let value = res.data
                //         // result = value.toString();
                //         console.log(value);
                //         setResult(value.toString());
                //         //console.log(`..++...${result.toString()}`);
                //         // return value;
                //     }

                // );
                const res1 = await axios.get(`${base_url}div/${previousNumber}/${currentNumber}`);
                console.log("ResultFromAddition===========>", res1)
                setCurrent(res1.data.toString());
                break;

            case "*":
                // result = previousNumber * currentNumber;
                // axios.get(`${base_url}mul/${previousNumber}/${currentNumber}`).then(
                //     (res) => {
                //         // setResult(res.data);
                //         let value = res.data
                //         // result = value.toString();
                //         console.log(value);
                //         setResult(value.toString());

                //     }
                // );
                const res2 = await axios.get(`${base_url}mul/${previousNumber}/${currentNumber}`);
                console.log("ResultFromAddition===========>", res2)
                setCurrent(res2.data.toString());
                break;
            case "+":
                //result = previousNumber + currentNumber;
                // axios.get(`${base_url}add/${previousNumber}/${currentNumber}`).then(
                //     (res) => {
                //         // setResult(res.data);
                //         let value = res.data
                //         // result = value.toString();
                //         console.log(value);
                //         setResult(value.toString());

                //     }
                // );
                console.log(".....previousNumber.+ " + previousNumber + "  " + currentNumber);
                const res = await axios.get(`${base_url}add/${previousNumber}/${currentNumber}`);
                console.log("ResultFromAddition===========>", res)
                setCurrent(res.data.toString());
                break;
            case "-":
                //result = previousNumber - currentNumber;
                // axios.get(`${base_url}sub/${previousNumber}/${currentNumber}`).then(
                //     (res) => {
                //         // setResult(res.data);
                //         let value = res.data
                //         // result = value.toString();
                //         console.log(value);
                //         setResult(value.toString());

                //     }

                // );
                const res3 = await axios.get(`${base_url}sub/${previousNumber}/${currentNumber}`);
                console.log("ResultFromAddition===========>", res3)
                setCurrent(res3.data.toString());
                break;

            default:
                return;
        }
        // console.log(`......${result}`);
        return result;
    };
    //console.log(compute());

    return (
        <>

            <Container>
                <Screen>
                    <Prevoius>{prevoius}{operations}</Prevoius>
                    <Current>{current}</Current>

                </Screen>

                <Button operation data={"mc"} onClick={memoryoperation}>mc</Button>
                <Button operation data={"mr"} onClick={memoryoperation}>mr</Button>
                <Button operation data={"m+"} onClick={memoryoperation}>m+</Button>
                <Button operation data={"m-"} onClick={memoryoperation}>m-</Button>

                <Button operation data={"1/x"} onClick={mathemeticaoperation}>1/x</Button>
                <Button operation data={"x²"} onClick={mathemeticaoperation}>x²</Button>
                <Button operation data={"√x"} onClick={mathemeticaoperation}>√x</Button>
                <Button operation data={""} onClick={mathemeticaoperation}></Button>

                <Button operation data={"+"} onClick={chooseOperationHandler}>+</Button>
                <Button operation data={"-"} onClick={chooseOperationHandler}>-</Button>
                <Button operation data={"*"} onClick={chooseOperationHandler}>*</Button>
                <Button operation data={"÷"} onClick={chooseOperationHandler}>÷</Button>

                <Button data={9} onClick={appendValueHandler}>9</Button>
                <Button data={8} onClick={appendValueHandler}>8</Button>
                <Button data={7} onClick={appendValueHandler}>7</Button>
                <Button del onClick={deleteHandler}>DEL</Button>




                <Button data={4} onClick={appendValueHandler}>4</Button>
                <Button data={5} onClick={appendValueHandler}>5</Button>
                <Button data={6} onClick={appendValueHandler}>6</Button>
                <Button control onClick={allclearHandler}>Clear</Button>



                <Button data={1} onClick={appendValueHandler}>1</Button>
                <Button data={2} onClick={appendValueHandler}>2</Button>
                <Button data={3} onClick={appendValueHandler}>3</Button>


                <Button decimal data={"."} onClick={appendValueHandler}>.</Button>
                <Button data={0} onClick={appendValueHandler}>0</Button>


                <Button equals onClick={equalHandler}>=</Button>


            </Container>
        </>


    )
}

export default Calculator
