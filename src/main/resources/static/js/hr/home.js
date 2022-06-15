const getList = async (input1)=>{
    const input2 = document.querySelector("#input2");
    input2.value = input1;

    await fetch(`/some-request/input3?input2=${input2.value}`,{
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(res=>res.json())
    .then(({msg, result, status})=> {
        if(status=='OK'){
            console.log(msg, result, status);
            setInput3List(result);
        }else{
            console.error(msg, result, status);
            const input3List = document.querySelector("#input3List");
            input3List.innerHTML = '';
        }
    });
}

const postTest = async ()=>{
    const input2 = document.querySelector("#input2");
    const input3 = Array.from(document.querySelectorAll('[name=input3]')).filter(input=>{
        return input.checked;
    }).map(input=>input.value);

    const content = {
        input1: input2.value,
        input2: input2.value,
        input3: input3.join(',')
    };

    await fetch('/some-request',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(content)
    })
    .then(res=>res.json())
    .then(({msg, result, status})=> {
        console.log(msg, result, status);
    });
}

function setInput3List(list){
    const input3List = document.querySelector("#input3List");
    input3List.innerHTML = '';

    list.forEach(item=>{
        const div = document.createElement('div');

        let check = document.createElement('input');
        check.type = 'checkbox'
        check.id = `chk_${item}`;
        check.name = 'input3';
        check.value = item;
        let label = document.createElement('label');
        label.htmlFor = `chk_${item}`;
        label.textContent = item;

        div.appendChild(label);
        div.appendChild(check);
        input3List.appendChild(div);
    });
}