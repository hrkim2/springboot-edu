(()=>{
    console.log(`before load ==> ${getTime()}`);
})();

document.addEventListener("DOMContentLoaded", ()=>{
    console.log(`after load ==> ${getTime()}`);
    const main = document.querySelector('main');
    main.innerHTML = 'CONTENT';
    main.appendChild(getBtn('header'));
    main.appendChild(getBtn('main'));
    main.appendChild(getBtn('footer'));
});

function getElement(elName){
    const el = document.querySelector(elName);
    if(!el || el==null){
        console.log(`not found ==> ${getTime()}`);
    }else{
        console.log(el.innerHTML);
        console.log(`event complete ==> ${getTime()}`);
    }
}

function getTime(){
    const date = new Date();
    return `${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}:${date.getMilliseconds()}`;
}

function getBtn(name){
    const div = document.createElement('div');
    let btn = document.createElement('button');
    btn.innerText = `get text from ${name}`;
    btn.addEventListener('click', ()=>getElement(name));

    div.appendChild(btn);

    return div;
}