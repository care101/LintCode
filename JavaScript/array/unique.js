// map
function unique1(arr) {
  const seen = new Map();
  return arr.filter(a => !seen.has(a) && seen.set(a, 1));
}

// set
function unique2(arr) {
  return Array.from(new Set(arr));
}
function unique3(arr) {
  return [...new Set(arr)];
}

// filter
function unique4(arr) {
  return arr.filter((value, index, self) => {
    return self.indexOf(value) === index;
  });
}

const arr = ['a', 1, 'a', 2, '1'];
console.log(unique3(arr));