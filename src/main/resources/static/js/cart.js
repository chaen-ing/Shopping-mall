// 장바구니 추가
const cartAddButton = document.getElementById('cart-add-btn');

if(cartAddButton){
    cartAddButton.addEventListener("click", (event) =>{
        let productId = document.getElementById('product-id').value;

        fetch("/api/cart",{
            method : "POST",
            headers : {
                "Content-Type" : "application/json",
            },
            body : JSON.stringify({
                productId: productId,
                amount: document.getElementById('amount').value
            }),
        }).then(() => {
            alert('장바구니에 담았습니다.');
            location.replace(`/products/id/`+productId);
        });
    });
}

// 장바구니 삭제
// const cartDeleteButton = document.getElementById('cart-delete-btn');
//
// if(cartDeleteButton){
//     cartDeleteButton.addEventListener('click', event => {
//         let id = document.getElementById('cartItemId').value;
//         fetch(`/api/cart/delete/${id}`,{
//             method: 'DELETE'
//         })
//             .then(() => {
//                 alert('삭제 완료.');
//                 location.replace('/cart')
//             });
//
//     });
// }
document.addEventListener('DOMContentLoaded', function () {
    const deleteButtons = document.querySelectorAll('.delete-btn');

    deleteButtons.forEach(button => {
        button.addEventListener('click', event => {
            const cartItemId = button.getAttribute('data-id');
            console.log(`Deleting cart item with ID: ${cartItemId}`);  // 디버깅 메시지 추가

            fetch(`/api/cart/delete/${cartItemId}`, {
                method: 'DELETE'
            })
                .then(response => {
                    if (response.ok) {
                        alert('삭제 완료.');
                        location.reload();  // 현재 페이지를 새로고침하여 변경 사항을 반영합니다.
                    } else {
                        console.error('Delete failed with status:', response.status);
                        alert('삭제 실패.');
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('삭제 중 오류가 발생했습니다.');
                });
        });
    });

    console.log('Delete buttons initialized:', deleteButtons.length);  // 초기화 확인 메시지
});

