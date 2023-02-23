console.log("Ajax hands-on");
let el = document.getElementById("displayWithId");
if(el)
el.addEventListener("click", promiseDatabase);
function promiseDatabase(){
  return new Promise(function(resolve, reject){
    const xhr = new XMLHttpRequest()
    xhr.open('GET',"https://dummy.restapiexample.com/api/v1/employees", true)
    xhr.onload = function(){
      console.log("Data is loading...")
      resolve(this.responseText);
    }
    xhr.onerror = function(){
      reject(new Error("Network Error"))
    }
    xhr.send()
  })
}

promiseDatabase().then(function(jsonString){
  let obj = JSON.parse(jsonString)
  let details = document.getElementById("employee_details");
  employee_id = prompt("Please enter your id");
     str=""
    var i=0;
var data=obj["data"];

    console.log(data[employee_id-1]);
    for(i in obj){
      str = `Employee ID: ${data[employee_id-1].id}<br>
      Employee Name: ${data[employee_id-1].employee_name}<br>
      Employee Salary: ${data[employee_id-1].employee_salary}<br>
      Employee Age: ${data[employee_id-1].employee_age}`
    }
   details.innerHTML = str;

}).catch(function(err){
  console.error(err);
})