async function getPostData(postId) {
    try {
        const response = await fetch(`https://jsonplaceholder.typicode.com/posts/${postId}`);

        if (!response.ok) {
            throw new Error(`HTTP Error: ${response.status}`);
        }

        const post = await response.json();
        console.log("Post Data:", post);
        return post;
    } catch (error) {
        console.error("Error fetching post:", error);
    }
}

// Calling the function
getPostData(1);
