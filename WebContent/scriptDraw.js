function draw(ttt) {
    var canvas = document.getElementById('canvas');
    if (canvas.getContext) {
        var ctx = canvas.getContext("2d");
        
        for (var i = 2; i < 22; i++) {
            for (var j = 3; j < 13; j++) {
                if(ttt[i][j]==1){
                    ctx.fillStyle = "rgb(255, 0, 0)";
                    ctx.fillRect(j*15, i*15, 14, 14);
                    ctx.fillStyle = "rgb(0, 0, 0)";
                    continue;
                }
                if(ttt[i][j]==2){
                    ctx.fillStyle = "rgb(0, 0, 255)";
                    ctx.fillRect(j*15, i*15, 14, 14);
                    ctx.fillStyle = "rgb(0, 0, 0)";
                    continue;
                }
                ctx.fillStyle = "rgb(0, 0, 0)";
                ctx.fillRect(j*15, i*15, 14, 14);
            }
        }
    }
}

function drawempty() {
    var canvas = document.getElementById('canvas');
    if (canvas.getContext) {
        var ctx = canvas.getContext("2d");
        
        for (var i = 2; i < 22; i++) {
            for (var j = 3; j < 13; j++) {
                ctx.fillStyle = "rgb(0, 0, 0)";
                ctx.fillRect(j*15, i*15, 14, 14);
            }
        }
    }
}