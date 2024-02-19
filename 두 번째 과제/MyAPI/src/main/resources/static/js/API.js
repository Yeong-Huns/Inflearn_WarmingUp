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