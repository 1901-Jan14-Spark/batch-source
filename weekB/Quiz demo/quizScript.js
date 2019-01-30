window.onload = function() {
    buildQuiz();
    // evaluateQuiz();
    document.getElementById("submit").addEventListener("click", evaluateQuiz());
}

function buildQuiz() {

    let quizContent = "";

    for(index in myQuestions) {
        let answerHTML = "";
        let questionNumber = index + 1;
        let currentQuestion = myQuestions[index];

        for(letter in currentQuestion.answers) {
            answerHTML += `<input type="radio" name="question ${questionNumber}" value="${letter}"/> <label> ${letter} : ${currentQuestion.answers[letter]}
            </label><br>`;
        }
        let questionContent = `<div class="question"><strong> ${questionNumber}, ${currentQuestion.question}</strong></div> <div class="answers">${answerHTML}</div>`;

        quizContent += questionContent;
    }

    document.getElementById("quiz").innerHTML = quizContent;
}

function evaluateQuiz() {
    let numCorrect = 0;
    let answerContainer = document.getElementById("quiz").getElementsByClassName("answers");

    for(index in myQuestions) {
        let correctAnswer = myQuestions[index].correctAnswer;
        let currentQuestion = answerContainer[index].getElementsByTagName("input");

        for(answer of currentQuestion) {
            if(answer.checked && (answer.value === correctAnswer)) {
                answer.nextSibling.style.color = "limegreen";
                numCorrect++;
            }
        }
        // console.log(`Correct answers: ${numCorrect}`);
        document.getElementById("results").innerHTML = `Correct answers ${numCorrect} out of` 
    }

    // display results
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