var getPost = async (postId) => {

    var response = await fetch(`https://jsonplaceholder.typicode.com/posts/${postId}`);
    var content = await response.json();
    console.log('inside getPost', content);
    return content;
}

getPosts = () => {
    getPost(1)
        .then((content) => {
            console.log(content);

            var node = document.getElementById('content');
            node.innerHTML = content.id + ' - ' + content.title;
        });
}