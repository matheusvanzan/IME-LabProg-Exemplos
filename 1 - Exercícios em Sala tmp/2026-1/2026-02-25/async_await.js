
const fetchUserData = async () => {
    const response = await fetch('https://jsonplaceholder.typicode.com/users/1');
    return response;
}

const myFunction2 = async () => {

    const response1 = fetchUserData();
    console.log(response1);
    console.log('Hello 2');

    response1.then();

}
myFunction2();