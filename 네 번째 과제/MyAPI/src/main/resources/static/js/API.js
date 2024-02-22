function calcBtn() {
    let num1 = document.getElementById('num1').value;
    let num2 = document.getElementById('num2').value;

    fetch(`/api/v1/calc?num1=${num1}&num2=${num2}`, {
        method: 'get'
    })
        .then(response => {
            if (!response.ok)
                throw new Error('서버로부터 값을 받아오지 못했습니다(calc)')
            return response.json();
        })
        .then(data => { //{"add": , "minus": , "multiply": }
            const addValue = data.add;
            const minusValue = data.minus;
            const multiplyValue = data.multiply;
            $("#calc").html(
                `
    <h3 class="badge badge-light text-danger">실행 결과 : </h3><br>
    {<br>
    <span class="text-success">"add"</span>: <span class="text-danger">${addValue},</span><br>
    <span class="text-success">"minus"</span>: <span class="text-danger">${minusValue},</span><br>
    <span class="text-success">"multiply"</span>: <span class="text-danger">${multiplyValue}</span><br>
    }
    `
            );
        })
        .catch(error => {
            alert('/api/v1/calc 오류 \n입력값을 확인해주세요.')
        })
}

function day_of_the_week_Btn() {
    let selectedDate = document.getElementById('day_of_the_week').value;
    fetch(`api/day-of-the-week?date=${selectedDate}`, {
        method: 'get'
    })
        .then(response => {
            if (!response.ok)
                throw new Error('서버로부터 값을 받아오지 못했습니다(dayOfTheWeek)')
            return response.json();
        })
        .then(data => { // {"dayOfTheWeek": "MON"}
            const dayOfTheWeek = data.dayOfTheWeek;
            $("#day_of_week").html(
                `
                <h3 class="badge badge-light text-danger">실행 결과 : </h3><br>
                {<br>
                <span class="text-success">"dayOfTheWeek" : "${dayOfTheWeek}"</span><br>
                }
                `
            )
        })
        .catch(error => {
            alert("/api/day-of-the-week 오류\n입력값을 확인해주세요.")
        })

}

function addNumbers() {
    let numbersCollection = document.getElementsByClassName("numbers")
    let numbersArray = Array.from(numbersCollection).map(number => parseFloat(number.value)).filter(number => !isNaN(number));
    fetch(`api/v1/addNumbers`, {
        method: 'post',
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({numbers: numbersArray})
    })
        .then(response => {
            if (response.status !== 201) //201 아니면 예외처리
                throw new Error('서버로부터 값을 받아오지 못했습니다(addNumbers)')
            console.log(response)
            return response.json();
        })
        .then(data => {
            const addNumber = data; //key가 없어서 그냥 변환된 값만 받으면 됨
            $("#returnAddNumbers").html(
                `
                <h3 class="badge badge-light text-danger">실행 결과 : </h3><br>
                <span class="text-danger">${addNumber}</span><br>
                `
            )
        })
        .catch(error => {
            alert("/api/v1/addNumbers 오류\n입력값을 확인해주세요.")
        })
}

function saveFruitInfoBtn() {
    const fruitName = document.getElementById("fruitName").value;
    const warehousingDate = document.getElementById("warehousingDate").value;
    const fruitPrice = document.getElementById("fruitPrice").value;
    if (!fruitName || !warehousingDate || !fruitPrice) {
        alert("모든 값을 입력해주세요.")
    } else {
        fetch('api/v1/fruit', {
            method: 'post',
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({"name": fruitName, "warehousingDate": warehousingDate, "price": fruitPrice})
        })
            .then(response=>{
                if(!response.ok)
                    throw new Error('서버로부터 응답이 없습니다(saveFruit)')
                return response.status;
            })
            .then(status => {
                $("#saveFruitInfo").html(
                    `
                <h3 class="badge badge-light text-danger">실행 결과 : </h3>
                <span class="badge badge-ligth text-danger">${status}</span><br>
                `
                )
            })
            .catch(error => {
                alert("입력값을 확인해주세요!")
            })
    }
}
function soldFruitInfoBtn(){
    const fruitId = document.getElementById("fruitId").value;
    fetch("api/v1/fruit" , {
        method: "put",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({"id": fruitId})
    })
        .then(response => {
            if(!response.ok) throw new Error("서버로 부터 응답이 없습니다. (putError)")
            return response.status;
        })
        .then(status => {
            $("#soldFruitInfo").html(
                `
                <h3 class="badge badge-light text-danger">실행 결과 : </h3>
                <span class="badge badge-light text-danger">${status}</span>
                `
            )
        })
        .catch(error=>{
            alert("존재하지않거나 이미 팔린상품입니다.")
        })
}
function salesAmountBtn(){
    const fruitSaleName = document.getElementById("fruitSaleName").value;
    fetch(`/api/v1/fruit/stat?name=${fruitSaleName}` , {
        method: 'get',
    })
        .then(response => {
            if(!response.ok) throw new Error("서버로부터 응답이 없습니다.(3번오류)")
            return response.json()
        })
        .then(data=>{
            const salesAmount = data.salesAmount;
            const notSalesAmount = data.notSalesAmount;
            console.log(salesAmount + " : " + notSalesAmount)
            $("#salesAmountID").html(
                `
                <h3 class="badge badge-light text-danger">실행 결과 : </h3><br>
                 {<br>
                &nbsp;&nbsp;<span class="text-success">"salesAmount"</span>: <span class="text-danger">${salesAmount},</span><br>
                &nbsp;&nbsp;<span class="text-success">"notSalesAmount"</span>: <span class="text-danger">${notSalesAmount}</span><br>
                }<br><br>
                `
            )
        })
        .catch(error=>{
            alert("존재하는 과일이 아닙니다.")
        })
}