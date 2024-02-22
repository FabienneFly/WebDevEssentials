let solveUsed = 0;

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
  let expression = document.getElementById("result").value;
  let result = math.evaluate(expression);
  document.getElementById("result").value = result;
  solveUsed += 1;
}

function clearDisplay() {
  document.getElementById("result").value = "";
  solveUsed = 0;
}
const clearButton = document.getElementById("clear");
clearButton.addEventListener("click", clearDisplay);

document.addEventListener("keydown", (event) => {
  const key = event.key;
  if (key === "Enter") {
    solve();
  } else if (key === "Escape") {
    clearDisplay();
  } else if (!isNaN(key) || "+-*/.".includes(key)) {
    event.preventDefault();
    displayValue(key);
  }
});
