const arr = [
  "a",
  "b",
  "c",
  "d",
  "e",
  "f",
  "g",
  "h",
  "i",
  "j",
  "k",
  "l",
  "m",
  "n",
  "o",
  "p",
  "q",
  "r",
  "s",
  "t",
  "u",
  "v",
  "w",
  "x",
  "y",
  "z",
];

function find(start, end) {
  const inputValue = document.getElementById("input").value;

  if (start > end) {
    document.getElementById("output").value = "Not Found";
  }

  //rounds down
  const middle = Math.floor((start + end) / 2);

  if (arr[middle] === inputValue) {
    if (middle == 0) {
      document.getElementById("output").value =
        "At the " + (middle + 1) + "st place in the alphabet";
    }
    if (middle == 1) {
      document.getElementById("output").value =
        "At the " + (middle + 1) + "nd place in the alphabet";
    }
    if (middle == 2) {
      document.getElementById("output").value =
        "At the " + (middle + 1) + "rd place in the alphabet";
    } else {
      document.getElementById("output").value =
        "At the " + (middle + 1) + "th place in the alphabet";
    }
  }

  if (arr[middle] > inputValue) {
    return find(start, middle - 1);
  }

  if (arr[middle] < inputValue) {
    return find(middle + 1, end);
  }
}
