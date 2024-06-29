// 삭제
const deleteButton = document.getElementById('delete-btn');

if(deleteButton){
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById(
            'product-id').value;
        fetch(`/api/products/id/${id}`,{
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제 완료.');
                location.replace('/products')
            });
    });
}

// 수정
const modifyButton = document.getElementById('modify-btn');

if(modifyButton){
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/products/id/${id}`,{
            method: 'PUT',
            headers: {
                "Content-Type" : "application/json",
            },
            body : JSON.stringify({
                name : document.getElementById('name').value,
                description:document.getElementById('description').value,
                price : document.getElementById('price').value,
                amount : document.getElementById('amount').value
            })
        })
            .then(() => {
                alert('수정 완료.');
                location.replace(`/products/id/${id}`)
            });
    });
}

// 등록
const createButton = document.getElementById('create-btn');

if(createButton){
    createButton.addEventListener("click", (event) =>{
        fetch("/api/products",{
            method : "POST",
            headers : {
                "Content-Type" : "application/json",
            },
            body : JSON.stringify({
                name : document.getElementById('name').value,
                description:document.getElementById('description').value,
                price : document.getElementById('price').value,
                amount : document.getElementById('amount').value
            }),
        }).then(() => {
                alert('등록 완료.');
                location.replace(`/products`)
            });
    });
}

