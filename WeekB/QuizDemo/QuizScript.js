window.onload = function(){
    buildQuiz();
    // evaluateQuiz();
    document.getElementById("submit").addEventListener("click", evaluateQuiz);
}

function buildQuiz(){

    let quizContent = "";
    
    for(index in myQuestions){
        let answersHTML = "";
        let questionNumber = Number(index) + 1; 
        let currentQuestion = myQuestions[index];

        for(letter in currentQuestion.answers){
            answersHTML += `<input type="radio" name="question${questionNumber}" value="${letter}" /> <label> ${letter} : ${currentQuestion.answers[letter]}</label><br>`;
        }

        let questionContent = `<div class="question"> <strong> ${questionNumber}. ${currentQuestion.question} </strong> </div> <div class="answers"> ${answersHTML} </div>`;

        quizContent += questionContent;
    }

    document.getElementById("quiz").innerHTML = quizContent;
}

// this will be the function associated with our event listener
function evaluateQuiz(){

    let numCorrect = 0;
    let answerContainer = document.getElementById("quiz").getElementsByClassName("answers");

    for(index in myQuestions){
        let correctAnswer = myQuestions[index].correctAnswer;
        let currentAnswers = answerContainer[index].getElementsByTagName("input");
        // console.log(correctAnswer);
        // console.log(currentAnswers);
        for(answer of currentAnswers){
            if(answer.checked && (answer.value === correctAnswer)){
                // console.log(answer);
                // console.log(answer.nextSibling);
                // console.log(answer.nextElementSibling);
                answer.nextElementSibling.style.color = "limegreen";
                numCorrect++;
            } else if (answer.checked){
                answer.nextElementSibling.style.color = "red";
            }
        }
    }
    //console.log("Number correct = "+numCorrect);
    // display results to user
    document.getElementById("results").innerHTML = `${numCorrect} out of ${myQuestions.length} were correct`;
}



const myQuestions = [
    {
        question: '7 + 7 + "7" = ?',
        answers: {
            a: '"777"',
            b: '"147"',
            c: 21
        },
        correctAnswer: "b"
    },
    {
        question: "What is the inherit boolean value of an empty object?",
        answers: {
            a: 'true',
            b: 'false',
            c: 'undefined'
        },
        correctAnswer: "a"
    },
    {
        question: "What is the inherit boolean value of an empty array?",
        answers: {
            a: 'true',
            b: 'false',
            c: 'undefined' 
        },
        correctAnswer: "a"
    },
    {
        question: "typeOf(NaN) = ?",
        answers: {
            a: 'NaN',
            b: 'undefined',
            c: 'Number',
        },
        correctAnswer: "c"
    },
    {
        question: "NaN == NaN",
        answers: {
            a: "true",
            b: "false",
            c: "undefined"
        },
        correctAnswer: "b"
    },
    {
        question: 'What is the inherit boolean value of "false"?',
        answers: {
            a: "true",
            b: "false",
            c: "undefined"
        },
        correctAnswer: "a"
    }
]