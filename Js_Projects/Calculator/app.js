var solveUsed = 0;

function displayValue(val) {
  if (solveUsed > 0) {
    document.getElementById("result").value = "";
    solveUsed = 0;
    document.getElementById("result").value += val;
  } else {
    document.getElementById("result").value += val;
  }
}

function solve() {
  let x = document.getElementById("result").value;
  let y = math.evaluate(x);
  document.getElementById("result").value = y;
  solveUsed += 1;
}

const clear = document.getElementById("clear");
clear.addEventListener("click", () => {
  document.getElementById("result").value = "";
});
