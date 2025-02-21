async function fetchPostsSequentially(postIds) {
    for (const postId of postIds) {
        try {
            console.log(`Fetching post ${postId}...`);
            const response = await fetch(`https://jsonplaceholder.typicode.com/posts/${postId}`);

            if (!response.ok) {
                throw new Error(`HTTP Error: ${response.status}`);
            }

            const post = await response.json();
            console.log("Post Data:", post);
        } catch (error) {
            console.error(`Error fetching post ${postId}:`, error);
        }
    }
}

// Calling the function
fetchPostsSequentially([1, 2, 3]);
