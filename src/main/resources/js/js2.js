var handler = {
    id: "123456",
    init: function () {
        document.addEventListener(
            "click",
            function (event) {
                this.doSomething(event.type)
            }.bind(this),
            false
        );
    },
    doSomething: function (type) {
        console.log(type);
        console.log("Handling " + type + " for " + this.id);
    },
};
handler.init();