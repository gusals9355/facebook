const fileList = [];
const ctntElem = document.querySelector('#ctnt');
const selectImgArrElem = document.querySelector('#selectImgArr');
const btnUploadElem = document.querySelector('#btnUpload');
const displayImgListElem = document.querySelector('#displayImgsList');

selectImgArrElem.addEventListener('change', ()=>{
    const files = selectImgArrElem.files;
    for(let i=0; i<files.length; i++){
        fileList.push(files[i]);
    }
    displaySelectedImgArr();
})

//선택한 이미지들 디스플레이하기
function displaySelectedImgArr(){
    displayImgListElem.innerHTML = '';

    for(let i=0; i<fileList.length; i++){
        const item = fileList[i];
        const reader = new FileReader();
        reader.readAsDataURL(item);
        //로드 한후
        reader.onload = function (){
            const img = document.createElement('img');
            img.addEventListener('click', () =>{
                fileList.splice(i, 1); //몇번째부터 몇개를 잘라낸다.
                displaySelectedImgArr();
            })
            img.src = reader.result;
            displayImgListElem.append(img);
        }
    }
}

//등록버튼 클릭시
btnUploadElem.addEventListener('click', () => {

})