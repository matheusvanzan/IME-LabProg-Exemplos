const myPromise = new Promise((resolve, reject) => {
    let success = true; // Simulating a condition

    setTimeout(() => {
        if (success) {
            resolve("A - Operation successful!");
        } else {
            reject("B - Operation failed!");
        }
    }, 2000);
});

// Handling the Promise
myPromise
    .then(result => console.log('1' + result))  // Runs if resolved
    .catch(error => console.error('2' + error)) // Runs if rejected
    .finally(() => console.log("Promise completed"));