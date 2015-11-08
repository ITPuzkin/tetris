document.onkeyup = checkKeys;
function checkKeys(event){
    var KeyID = event.keyCode;
    switch(KeyID)
    {
        
        case 37:
                a="a";
                SendPost(a);//Arrow Left
                a=null;
                break;
            case 38:
                a="r";
                SendPost(a);//"Arrow Up";
                a=null;
                break;
            case 39:
                a="b"
                SendPost(a);//"Arrow Right";
                a=null;
                break;
            case 40:
                a="c";
                SendPost(a);//"Arrow Down";
                a=null;
                break;
        }
}