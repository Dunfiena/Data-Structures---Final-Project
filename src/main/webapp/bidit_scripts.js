function loadFileClear(){
    var image = document.getElementById('output');
    image.parentNode.removeChild(image)
}

function checkBid(login, itemBase, bidAmount) {
    if (login === false) {
        alert("Please log in before placing a bid")
        return false
    }else if(itemBase>bidAmount){
        alert("Please ensure that your bid is greater than the starting price of th item")
        return false
    }else {
        return true
    }
}