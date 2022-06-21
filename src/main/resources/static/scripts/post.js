// get posts from local storage
let title = localStorage.getItem("postTitle")
let desc = localStorage.getItem("postDesc");

// get html node for where to place poss
let postTitle = document.getElementById("title");
let postDesc = document.getElementById("desc");
let postImg = document.getElementById("imgSrc");

let counter = 1;

// set the values to their respective tags
postTitle.textContent = title;
if (desc === ""){
  postImg.src = "../images/pexels-anna-nekrashevich-8532637.jpg";
} else {
  postDesc.textContent = desc;
}

localStorage.clear;



function submitPost(event) {
  event.preventDefault();
  let divComment = document.getElementById('commentDiv');
  console.log(divComment);

  let addCommentVal = document.getElementById('addComment');
  let addNameVal = document.getElementById('addName');

  let pattern = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
  
  let result = pattern.test(addNameVal);
  if (result == false) {
    alert("Not an email!")
  }

  console.log(addCommentVal.value);
  console.log(addNameVal.value)

  const newDiv = document.createElement("div");
  newDiv.className = "columns-1 my-2";
  let commentId = "comment" + counter;
  newDiv.setAttribute("id", commentId);

  const newH4 = document.createElement("h4");
  const newP = document.createElement("p");

  newH4.className = "text-xs"

  newH4.textContent = addNameVal.value;
  newP.textContent = addCommentVal.value;

  newDiv.appendChild(newH4);
  newDiv.appendChild(newP);

  divComment.appendChild(newDiv);
  counter++;

}

const form = document.getElementById('formComment');
form.addEventListener('submit', submitPost)