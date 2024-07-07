const orderButton = document.getElementById('order-btn');

if (orderButton) {
    orderButton.addEventListener("click", (event) => {
        event.preventDefault(); // 기본 동작 중지

        const address = document.getElementById('address').value;
        const phoneNumber = document.getElementById('phone_number').value;

        const formData = {
            address: address,
            phone_number: phoneNumber
        };

        fetch("/api/order", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(formData),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('서버 오류가 발생했습니다.'); // 서버 오류 메시지를 throw
                }
                return response.json();
            })
            .then(data => {
                alert('주문이 성공적으로 완료되었습니다.');
                location.replace('/products');
            })
            .catch(error => {
                alert('재고가 부족합니다.');
                location.replace('/products');
            });
    });
}
