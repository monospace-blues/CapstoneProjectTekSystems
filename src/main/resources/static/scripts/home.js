function valueSendPost(event) {
  event.preventDefault;
  const title = event.parentNode.parentNode.id;
  console.log(title);
  let post = document.getElementById(title);

  console.log(post.childNodes);

  console.log(event.textContent);
  console.log(post.childNodes[3].textContent);
  
  localStorage.setItem("postTitle", event.textContent);
  localStorage.setItem("postDesc", post.childNodes[3].textContent);
}



