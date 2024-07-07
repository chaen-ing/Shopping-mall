// 탈퇴
const deleteButton = document.getElementById('delete-btn');

if(deleteButton){
    deleteButton.addEventListener('click', event => {

        fetch(`/api/user/delete`,{
            method: 'DELETE'
        })
            .then(() => {
                alert('탈퇴 완료.');
                location.replace('/logout')
            });
    });
}

// 수정
const modifyButton = document.getElementById('modify-btn');

if(modifyButton){
    modifyButton.addEventListener('click', event => {
        fetch(`/api/user/info`,{
            method: 'PUT',
            headers: {
                "Content-Type" : "application/json",
            },
            body : JSON.stringify({
                name : document.getElementById('name').value,
                phone_number: document.getElementById('phone_number').value,
                address: document.getElementById('address').value
            })
        })
            .then(() => {
                alert('수정 완료.');
                location.replace(`/user/info`)
            });
    });
}