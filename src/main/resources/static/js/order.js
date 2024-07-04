const orderButton = document.getElementById('order-btn');

if (orderButton) {
    orderButton.addEventListener("click", (event) => {
        fetch("/api/order", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                address: document.getElementById('address').value,
                phone_number: document.getElementById('phone_number').value
            }),
        })
            .then(response => {
                if (response.ok) {
                    alert('주문 완료.');
                    location.replace(`/user/cart`);
                } else {
                    alert('주문 실패.');
                    location.replace(`/user/cart`);
                }
            })
            .catch(() => {
                alert('네트워크 오류 또는 서버 문제로 주문을 처리할 수 없습니다.');
                location.replace(`/user/cart`);
            });
    });
}
