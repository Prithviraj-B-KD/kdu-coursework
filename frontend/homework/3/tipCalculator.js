const r = [140, 45, 280];

function tipCalculator(...args) {
  let tips = [];
  let totals = [];
  for (let i = 0; i < args.length; i++) {
    let bill = args[i];
    let total = 0;
    let tip = 0;
    if (bill < 50) {
      tip = bill * 0.2;
    } else if (bill < 200) {
      tip = bill * 0.15;
    } else {
      tip = bill * 0.1;
    }
    total = bill + tip;
    tips.push(tip);
    totals.push(total);
  }
  return [tips, totals];
}

const x = tipCalculator(...r);
console.log("tips: " + x[0]);
console.log("total bills: " + x[1]);
