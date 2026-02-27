const listBtn = document.getElementById("load-js")

listBtn.addEventListener("click", function() {

    console.log('Loading');

    fetch('https://jsonplaceholder.typicode.com/users')
    .then(resp => resp.json())
    .then(data => {
        // console.log(data);

        const listData = document.getElementById('user-list');
        // data.forEach(item => {
        //     console.log(item.id, item.name);
        //     const el = document.createElement('li');
        //     el.innerHTML = item.name;
        //     listData.appendChild(el);
        // });

        const liList = data.map(itemJson => {
            const el = document.createElement('p');
            el.innerHTML = itemJson.name;
            return el;
        });
        liList.forEach(i => listData.appendChild(i));
    });



});