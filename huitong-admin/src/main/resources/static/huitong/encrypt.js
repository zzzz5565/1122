let publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCH9rZTKdJduYSemxSRSCSf2NSKGHlS0m25O/Va9f4/igak4q1ORZWjs3Ennll/k1U2LrzyHCxaIK9XtI2YKXk3tFe2urMnN71clgkuXK0wt04Um/Ln6Av5TQ1/k16r1ZY3Ti0rdwokRSfjyQ5TVuQf1DXfeykzfrwLJZgsdGJS9wIDAQAB";
$(function() {

});
function isEncryption(){
    $.ajax({
        type: "post",
        url: ctx + "isEncryption",
        async:false,
        success: function(r) {
           // encryption=r;
            window.localStorage.setItem("encryption", r);
        }
    });
}
/*
* obj为字符串或自定义对象{}
*/
function encrypt1(obj){
    var encryption=window.localStorage.getItem("encryption");
    if((encryption!=""&&encryption!=undefined&&encryption!=null&&encryption!="undefined")||(encryption == true || encryption == "true"||encryption == false || encryption == "false")){
        if (encryption == true || encryption == "true") {
            let plaintext =encodeURIComponent(JSON.stringify(obj));
            if (publicKey == "" || publicKey == undefined || publicKey == null || publicKey == "undefined") {
                $.ajax({
                    type: "post",
                    url: ctx + "publicKey",
                    async: false,
                    success: function (r) {
                        publicKey = r;
                        const encryptor = new JSEncrypt()
                        encryptor.setPublicKey(publicKey) // 设置公钥
                        let ciphertext = encryptor.encryptLong2(plaintext) // 对数据进行加密
                        return ciphertext;
                    }
                });
            } else {
                const encryptor = new JSEncrypt()
                encryptor.setPublicKey(publicKey) // 设置公钥
                let ciphertext = encryptor.encryptLong2(plaintext) // 对数据进行加密
                return ciphertext;
            }
        }else{
            return obj;
        }
    }else {
        isEncryption();//赋值
        encrypt1(obj);
    }
}

/**新增或编辑form表单*/
function formToJsonEncryp(formId){
    var fields = $(formId).serializeArray();//获取表单字段
    var obj = {};
    $.each(fields, function(index, field) {
        if (obj[field.name]) {
            obj[field.name] = obj[field.name] + ("," + field.value);
        } else {
            obj[field.name] = field.value;
        }
    })
    var encryption=window.localStorage.getItem("encryption");
    if((encryption!=""&&encryption!=undefined&&encryption!=null&&encryption!="undefined")||(encryption == true || encryption == "true"||encryption == false || encryption == "false")) {
            if(encryption == true || encryption == "true") {
            let encrypJson = encrypt1(obj);
            return encrypJson;
        }else {
            return JSON.stringify(obj);
        }
    }else{
        isEncryption();//赋值
        formToJsonEncryp(formId);
    }
}

/**
* 1 导出时serializeArray()获取查询条件form字段后使用
* 2 其他功能serializeArray()获取表单字段后使用
* 3 fields格式如{ "name": "", "value": "" }
*/
function formFieldsToJsonEncryp(fields){
    var encryption=window.localStorage.getItem("encryption");
    var obj = {};
    let params = {};
    $.each(fields, function (index, field) {
        if (obj[field.name]) {
            obj[field.name] = obj[field.name] + ("," + field.value);
        } else {
            if(field.name.indexOf('params')>-1){
                let fieldname = field.name.replace('params[','').replace(']','');
                params[fieldname] = field.value;
            }else{
                obj[field.name] = field.value;
            }
        }
    })
    if(!$.isEmptyObject(params)){
        obj.params = params;
    }
    if((encryption!=""&&encryption!=undefined&&encryption!=null&&encryption!="undefined")||(encryption == true || encryption == "true"||encryption == false || encryption == "false")) {
        if(encryption == true || encryption == "true") {
            let encrypJson = encrypt1(obj);
            return encrypJson;
        }else {
            return JSON.stringify(obj);
        }
    }else{
        isEncryption();//赋值
        formFieldsToJsonEncryp(fields);
    }
}
/*
* 自定义对象
*/
function formJsonEncryp(obj){
    var encryption=window.localStorage.getItem("encryption");
    if((encryption!=""&&encryption!=undefined&&encryption!=null&&encryption!="undefined")||(encryption == true || encryption == "true"||encryption == false || encryption == "false")) {
        if(encryption == true || encryption == "true") {
            let encrypJson = encrypt1(obj);
            return encrypJson;
        }else {
            return JSON.stringify(obj);
        }
    }else{
        isEncryption();//赋值
        formJsonEncryp(obj);
    }
}
/**后端返回解密*/
let responseprivatekey="";
function responseDecryptHandler(res){
    var encryption=window.localStorage.getItem("encryption");
    if((encryption!=""&&encryption!=undefined&&encryption!=null&&encryption!="undefined")||(encryption == true || encryption == "true"||encryption == false || encryption == "false")) {
        if (encryption == true || encryption == "true") {
            //返回//前端私钥解密
            if (responseprivatekey == "" || responseprivatekey == undefined || responseprivatekey == null || responseprivatekey == "undefined") {
                $.ajax({
                    type: "post",
                    url: ctx + "responseprivatekey",
                    async: false,
                    success: function (keyres) {
                        responseprivatekey = keyres;

                        const encryptor = new JSEncrypt()
                        encryptor.setPrivateKey(responseprivatekey);
                        let plaintext = encryptor.decryptLong2(res);
                        plaintext = decodeURIComponent(plaintext);
                        res = eval('(' + plaintext + ')');
                    }
                });
            } else {
                const encryptor = new JSEncrypt()
                encryptor.setPrivateKey(responseprivatekey);
                let plaintext = encryptor.decryptLong2(res);
                plaintext = decodeURIComponent(plaintext);
                res = eval('(' + plaintext + ')');
            }
        }
        return res;
    }else{
        isEncryption();//赋值
        responseDecryptHandler(res);
    }
}