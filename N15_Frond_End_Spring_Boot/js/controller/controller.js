
    $("#item_section").css("display", "none");
    $("#order_section").css("display", "none");


    $("#item_nav").on("click", function () {
    $("#customer_section").css("display", "none");
    $("#item_section").css("display", "block");
    $("#order_section").css("display", "none");

});

    $("#customer_nav").on("click", function () {
    $("#item_section").css("display", "none");
    $("#customer_section").css("display", "block");
    $("#order_section").css("display", "none");
});

    $("#order_nav").on("click", function () {
    $("#item_section").css("display", "none");
    $("#customer_section").css("display", "none");
    $("#order_section").css("display", "block");
    $("#dateHead>span").text(new Date().toISOString().split("T")[0]);


});



    /*-------------------------------------------Customer section JS-------------------------------------------------------------*/


    const getAll = () =>{
    console.log("load Customer table")
    $.ajax({
    url: "http://localhost:8080/api/v1/customer/get",
    type:"GET",
    success:(resp)=>{
    console.log("Hi")
    let tableBody = $("#user_table_body");
    const customers = resp
    tableBody.empty();
    customers.map((customer, number) =>{
    let data = `<tr>
                                <td>${customer.id}</td>
                                <td>${customer.name}</td>
                                <td>${customer.address}</td>

                            </tr>`

    tableBody.append(data);
})
},
    error:(err) =>{
    console.log(err)
}
});
}

    getAll();

    $("#btn_save_customer").click((e) =>{
    console.log("save clicked")
    e.preventDefault();

    let cusId = $("#customer_id").val();
    let cusName = $("#customer_name").val();
    let cusAddress = $("#customer_address").val();

    console.log(cusId, cusName, cusAddress);

    let customer = {
    id: cusId,
    name: cusName,
    address: cusAddress
}

    $.ajax({
    url: "http://localhost:8080/api/v1/customer/save",
    type: "POST",
    headers:{
    'content-type': "application/json"
},
    data: JSON.stringify(customer),
    success: (resp)=>{
    if(resp.code === 201){
    alert("Customer saved.")
    getAll();
}else{
    alert("customer not save"+ resp.message)
}

},
    error:(err)=>{
    alert("Customer not saved.")
}


});


})

    $("#btn_update_customer ").click((event)=>{
    console.log("update")
    event.preventDefault()
    let cusId = $("#customer_id").val();
    let cusName = $("#customer_name").val();
    let cusAddress = $("#customer_address").val();

    console.log(cusId, cusName, cusAddress);

    let customer = {
    id: cusId,
    name: cusName,
    address: cusAddress
}

    $.ajax({
    url: "http://localhost:8080/api/v1/customer/update",
    type: "PUT",
    headers:{
    'content-type': "application/json"
},
    data: JSON.stringify(customer),
    success: (resp)=>{
    alert("Customer updated.");
    getAll();
},
    error:(err)=>{
    alert("Customer not updated.")
}

});

});

    $("#btn_delete_customer ").click((event)=>{
    console.log("customer delete")
    event.preventDefault();
    let cusId = $("#customer_id").val();



    $.ajax({
    url: `http://localhost:8080/api/v1/customer/delete/${cusId}`,
    type: "DELETE",

    success: (resp)=>{
    alert("Customer deleted.")
    getAll();
},
    error:(err)=>{
    alert("Customer not deleted.")
}

});

})


    /*-------------------------------------------Item section JS-------------------------------------------------------------*/

    const getAllItem = () =>{
    $.ajax({
        url: "http://localhost:8080/api/v1/item/get",
        type:"GET",
        success:(resp)=>{
            console.log("Hi")
            let tableBody = $("#item_table_body");
            const items = resp
            tableBody.empty();
            items.map((item, number) =>{
                let data = `<tr>
                                <td>${item.id}</td>
                                <td>${item.description}</td>
                                <td>${item.price}</td>
                                <td>${item.quantity}</td>

                            </tr>`

                tableBody.append(data);
            })
        },
        error:(err) =>{
            console.log(err)
        }
    });
}

    getAllItem();

    $("#btn_save_item").click((e) =>{
    console.log("save clicked")
    e.preventDefault();

    let itemId = $("#item_id").val();
    let itemName = $("#item_name").val();
    let itemPrice = $("#item_price").val();
    let itemQty = $("#item_qty").val();

    console.log(itemId, itemName, itemPrice, itemQty);

    let item = {
    id: itemId,
    description: itemName,
    price: itemPrice,
    quantity: itemQty
}

    $.ajax({
    url: "http://localhost:8080/api/v1/item/save",
    type: "POST",
    headers:{
    'content-type': "application/json"
},
    data: JSON.stringify(item),
    success: (resp)=>{
    alert("item saved.")
    getAllItem();
},
    error:(err)=>{
    alert("item not saved.")
}


});


})



    $("#btn_update_item ").click((event)=>{
    console.log("update")
    event.preventDefault()
    let itemId = $("#item_id").val();
    let itemName = $("#item_name").val();
    let itemPrice = $("#item_price").val();
    let itemQty = $("#item_qty").val();


    let item = {
    id: itemId,
    description: itemName,
    price: itemPrice,
    quantity: itemQty
}

    $.ajax({
    url: "http://localhost:8080/api/v1/item/update",
    type: "PUT",
    headers:{
    'content-type': "application/json"
},
    data: JSON.stringify(item),
    success: (resp)=>{
    alert("Item updated.");
    getAllItem();
},
    error:(err)=>{
    alert("Item not updated.")
}

});

});

    $("#btn_delete_item").click((event)=>{
    console.log("item delete")
    event.preventDefault();
    let itemId = $("#item_id").val();



    $.ajax({
    url: `http://localhost:8080/api/v1/item/delete/${itemId}`,
    type: "DELETE",

    success: (resp)=>{
    alert("Item deleted.")
    getAllItem();
},
    error:(err)=>{
    alert("Item not deleted.")
}

});

})


    /*-------------------------------------------Order section JS-------------------------------------------------------------*/

    const loadCustomer = () =>{
    console.log("load customer input")
    $.ajax({
    url: "http://localhost:8080/api/v1/orders/getAllCustomer",
    type:"GET",
    success:(resp)=>{
    $("#customer_select").empty();
    $("#customer_select").append(`<option>select a Customer</option>`);
    resp.map((customer, number) => {
    let data = ` <option>${customer.id} -  ${customer.name}</option>`
    console.log(data);
    $("#customer_select").append(data);

})
},
    error: (err)=>{

}

});


}

    loadCustomer();

    const loadItem = () =>{
    console.log("load item input")
    $.ajax({
    url: "http://localhost:8080/api/v1/orders/getAllItems",
    type:"GET",
    success:(resp)=>{
    $("#item_select").empty();
    $("#item_select").append(`<option>select a item</option>`);
    resp.map((item, number) => {
    let data = ` <option>${item.id} -  ${item.description}</option>`
    console.log(data);
    $("#item_select").append(data);

})
},
    error: (err)=>{

}

});


}

    loadItem();

    $("#item_select").on('input',function (){
    console.log("selected");
    let idName = $(this).val();
    let arr = idName.split("-")
    let id = arr[0];

    $.ajax({
    url: `http://localhost:8080/api/v1/orders/getItemById/${id}`,
    type:"GET",
    success:(resp)=>{
    $("#qtyOnHand").val(resp.quantity);
    $("#price").val(resp.price);


},
    error:() =>{

}
});

})

    const cart_array = [];

    $(document).ready(function (){
    $("#btn_add_item").click((e)=>{

        e.preventDefault();
        console.log("add to cart click")

        let itemId_name = $("#item_select").val();
        let code = itemId_name.split("-")[0].trim()
        let desc = itemId_name.split("-")[1]
        let qtyOnHand = parseInt($("#qtyOnHand").val());
        let price = parseFloat($("#price").val());
        let qty = parseInt($("#order_qty").val());
        let total =  qty * price;

        console.log(code, desc, qtyOnHand, price, qty, total)


        if (qty<qtyOnHand){

            let cartIndex = cart_array.findIndex(cartItem => {
                return cartItem.icode === code

            });
            console.log(cartIndex);
            if (cartIndex<0){
                let cart_item = {
                    icode:  code,
                    idesc: desc,
                    iqtyOnHand: qtyOnHand,
                    iprice: price,
                    iqty: qty,
                    itotal: total
                }
                cart_array.push(cart_item);
                loadCart();
                setTotal();
                clearInputs();
            }else {
                let cart_item = {
                    icode:  code,
                    idesc: desc,
                    iqtyOnHand: qtyOnHand,
                    iprice: price,
                    iqty: qty,
                    itotal: total
                }
                cart_array[cartIndex] = cart_item;
                loadCart();
                setTotal();
            }


        }else{
            alert("Not enough qty on hand");
        }
    })


});

    function loadCart(){
    $("#order_table_body").empty();
    cart_array.map((cartItem,number)=>{
    let data =`<tr>

                           <td>${cartItem.icode}</td>
                            <td>${cartItem.idesc}</td>
                            <td>${cartItem.iprice}</td>


                            <td>${cartItem.iqty}</td>
                            <td>${cartItem.itotal}</td>
                            <td><button class="delete-btn">Delete</button></td>

                        </tr>`

    $("#order_table_body").append(data);
})

}

    var total =0;
    function setTotal(){

    cart_array.map((cartItem, number)=>{
        total += cartItem.itotal;
    })
    $("#order_total").text(total);
}

    let clearInputs = () =>{
    $("#item_select").val();
    $("#qtyOnHand").val("");
    $("#price").val("");
    $("#order_qty").val("");
    loadItem();

}

    $("#btn_place_order").click((e)=>{
    e.preventDefault();
    let cusIdName = $("#customer_select").val();
    let oCusId = cusIdName.split("-")[0].trim();
    let oDate = $("#dateHead>span").text();
    let oTotal =total;
    console.log("cusId: "+oCusId+ ",oDate: "+oDate+",oTotal:"+ oTotal);

    let orderDTO = {
    id: "101",
    date: oDate,
    total: oTotal,
    customerId:oCusId
}

    let orderDetailDTOS = []
    cart_array.map((cartItem,number)=>{
    let orderDetailDTO = {
    id: "1",
    quantity: cartItem.iqty,
    i_id: cartItem.icode,
    o_id: "101"
}
    orderDetailDTOS.push(orderDetailDTO);
} )

    let placeOrderDTO = {
    orderDTO: orderDTO,
    orderDetailsDTO: orderDetailDTOS
}

    $.ajax({
    url:"http://localhost:8080/api/v1/orders/placeOrder",
    type: "POST",
    headers:{
    'content-type': "application/json"
},
    data:JSON.stringify(placeOrderDTO),
    success: (resp)=>{
    alert("place order success")
},
    error: (err)=>{
    alert("order not place successfully")
}
})


})

