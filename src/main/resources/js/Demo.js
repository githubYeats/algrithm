// ---------------- 作业1：以下代码，请用ES5实现 -----------------
// var handler = {
//     id: "123456",
//     init: function () {
//         document.addEventListener(
//             "click",
//             (event) => this.doSomething(event.type),
//             false
//         );
//     },
//     doSomething: function (type) {
//         console.log(type);
//         console.log("Handling " + type + " for " + this.id);
//     },
// };
// handler.init();

// -- 答 --
var handler = {
    id: "123456",
    init: function () {
        document.addEventListener(
            "click",
            (function (event) {
                this.doSomething(event.type)
            }).bind(this),
            false
        );
    },
    doSomething: function (type) {
        console.log(type);
        console.log("Handling " + type + " for " + this.id);
    },
};
handler.init();


// ------------- 作业2: 请说出以下代码输出结果，并解释原因？-----------------
function fun(n, o) {
    console.log(o);
    return {
        fun: function (m) {
            return fun(m, n);
        },
    };
}

var a = fun(0);
a.fun(1);
a.fun(2);
a.fun(3);

var b = fun(0).fun(1).fun(2).fun(3);
var c = fun(0).fun(1);
c.fun(2);
c.fun(3);

// -- 答 --
var a = fun(0); // 打印结果：undefined。 此时参数"o"未定义，故打印"undefined"。执行后，外层函数的第2个参数“o”被赋值为0，并且在之后的调用过程里始终不变。
a.fun(1); // 打印结果：0
a.fun(2); // 打印结果：0
a.fun(3); // 打印结果：0

var b = fun(0).fun(1).fun(2).fun(3);
// 打印结果，分别打印：undefined, 0, 1, 2。
// (1) undefined: fun(0), 此时"o"未被赋值，故为"undefined"。 执行fun(0)后，n=0传入到内部函数中，内层函数对象返回时，fun(n, o)中的"o"变成了0
// (2) 0: 因上一步，此时 o = 0，帮打印"0"
// (3) 1: 执行fun(0)后，返回的函数对象（称之为aT），再执行 aT.fun(1)，此时是"m=1"，传入内部后，外层函数的"0"变成了"1"，故其打印结果为"1"
// (4) 2: 原因同第（3）步

var c = fun(0).fun(1);
// 打印结果，分别打印：undefined, 0。
// (1) undefined: fun(0), 此时"o"未被赋值，故为"undefined"。 执行fun(0)后，n=0传入到内部函数中，内层函数对象返回时，fun(n, o)中的"o"变成了0
// (2) 0: 因上一步，此时 o = 0，帮打印"0"

c.fun(2); // 打印结果：1
c.fun(3); // 打印结果：1
// 在上一步"var c = fun(0).fun(1);"执行后，fun函数的参数"o"被赋值为了1，因此在继续调用的过程中，两次的打印结果都是1。
