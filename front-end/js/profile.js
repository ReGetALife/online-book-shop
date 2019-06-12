new Vue({
    el: '#top',
    data: {
        post: {
            activeIndex: '1000-1'
        }
    }
})

Vue.component('mycontent',{
    data:function () {
        return{
            name: '加载中...',
            phone: '加载中...',
            newName: '',
            newPass: '',
            isChangingName: false,
            isChangingPass: false
        }
    },
    methods:{
        changeName: function () {
            let that = this
            $.ajax({
                url: "http://139.199.75.41:8085/accounts/"+Cookies.get('uid'),
                type: "put",
                dataType: 'json',
                contentType: "application/json",
                headers: {
                    AUTHORIZE_UID: Cookies.get('uid'),
                    AUTHORIZE_TOKEN: Cookies.get('token')
                },
                data:JSON.stringify({
                    accountName: $('#newName').val()
                }),
                xhrFields: {
                    withCredentials: true//跨域
                },
                crossDomain: true
            }).done(function (data) {
                that.name = data.accountName
                that.isChangingName = false
                console.log(that.name)
                console.log(that.isChangingName)
                that.$forceUpdate()
            })
        }
    },
    created: function () {
        var that = this
        $.ajax({
            url: "http://139.199.75.41:8085/accounts/"+Cookies.get('uid'),
            type: "get",
            dataType: 'json',
            headers: {
                AUTHORIZE_UID: Cookies.get('uid'),
                AUTHORIZE_TOKEN: Cookies.get('token')
            }
        }).done(function (data) {
            //console.log(data)
            that.name = data.accountName
            that.phone = data.phone
        }).fail(function (xhr, status) {
            console.log('失败: ' + xhr.status + ', 原因: ' + status)
        })
    },
    template:`
    <el-card class="box-card">
            <div slot="header" class="clearfix" style="font-size: 20px;">
                <span>我的个人信息</span>
            </div>
            <div class="item">
                <el-image style="width: 100px; height: 100px"
                    src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" fit="cover">
                </el-image>
            </div>
            <div class="text item" style="font-size: 16px;">
                用户昵称:&nbsp;
                <span v-if="!isChangingName">{{name}}&nbsp;&nbsp;&nbsp;&nbsp;<el-button plain @click="isChangingName=true">修改</el-button></span>
                <span v-else>
                    <el-input v-model="newName" placeholder="请输入内容" id="newName"></el-input>
                    <el-button type="primary" plain @click="changeName">确定</el-button>
                    <el-button @click="isChangingName=false" plain>取消</el-button>
                </span>
            </div>
            <div class="text item" style="font-size: 16px;">
                密码&nbsp;&nbsp;&nbsp;&nbsp;
                <span v-if="!isChangingPass"><el-button plain @click="isChangingPass=true">修改</el-button></span>
                <span v-else>
                    <el-input v-model="newPass" placeholder="请输入内容" id="newPass"></el-input>
                    <el-button type="primary" plain>确定</el-button>
                    <el-button @click="isChangingPass=false" plain>取消</el-button>
                </span>
            </div>
            <div class="text item" style="font-size: 16px;">
                绑定手机:&nbsp;<span id="phone">{{phone}}</span>
            </div>
        </el-card>
    `
})
new Vue({
    el: '#content'
})

