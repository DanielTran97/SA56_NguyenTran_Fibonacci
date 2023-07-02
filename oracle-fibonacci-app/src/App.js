import React from "react";
import Value from "./Value";

function App() {
    const [num, setNum] = React.useState(0);
    const [data, setData] = React.useState(null);

    const params = {
        method: "GET",
        headers: {
            accept: 'application/json',
        }
    };
    const query = (num) => {fetch(`http://localhost:8000/fibonacci?integer=${num}`, params)}
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            return setData(data);
        })
    return (
        <div className = "App">
            Elements: <input type= "number" value={number} onChange={e => {setNum(e.target.value); query(e.target.value)}}/>
        {<Value data = {JSON.stringify(data)}/>}
        </div>
    );
}

export default App;
