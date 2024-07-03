document.getElementById('order-btn').addEventListener('click', function() {
    let cartItems = [];
    document.querySelectorAll('tbody tr').forEach(row => {
        cartItems.push({
            id: row.querySelector('#cartItemId').value,
            productId: row.querySelector('td:nth-child(1)').textContent,
            quantity: row.querySelector('td:nth-child(3)').textContent
        });
    });

    let orderData = {
        userId: 1, // 사용자 ID를 적절히 설정
        address: '배송 주소를 입력하세요',
        phoneNumber: '연락처를 입력하세요',
        cartItems: cartItems
    };

    fetch('/api/orders/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(orderData)
    })
        .then(response => response.json())
        .then(data => {
            alert('주문이 완료되었습니다. 주문번호: ' + data);
            location.replace('/orders');
        })
        .catch(error => {
            alert('주문에 실패했습니다.');
            console.error('Error:', error);
        });
});
