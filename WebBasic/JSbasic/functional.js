function average(x, y) {
  return (x + y) / 2;
}

const stats = (x, y) => ({
  average: (x + y) / 2,
  distance: Math.abs(x - y),
});
