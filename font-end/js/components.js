Vue.component('p_title', {
    props: ['posts'],
    data: function () {
        return {
            activeIndex: this.posts.activeIndex,
            search_input: ''
        }
    },
    methods: {
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
            /*
            if (parseInt(key) === 0)
                window.location.href = './index.html';
            else if (parseInt(key) === 1)
                window.location.href = './shoppping_cart.html';
            else if (parseInt(key) === 2)
                window.location.href = './indent.html';
            else if (parseInt(key) === 1000) {
                if (keyPath[1] === "1000-1")
                    window.location.href = '';
                else if (keyPath[1] === "1000-2")
                    window.location.href = '';
                else if (keyPath[1] === "1000-3")
                    window.location.href = '';
                else if (keyPath[1] === "1000-4")
                    window.location.href = '';
            }
            */

            //window.open('')
        }
    },
    template: `  
    <div id="title">
        <el-menu :default-active="activeIndex" mode="horizontal" @select="handleSelect"
                 background-color="#303133" text-color="#fff" active-text-color="#ffd04b">
            <el-menu-item index="0"><img class="icon" src="./res/icon.png" /><a class="title-name">虚拟书店</a></el-menu-item>
            <el-submenu index="1000" class="title-selection">
                <template slot="title">
                    <img class="icon" src="./res/portrait.png" />
                </template>
                <el-menu-item index="1000-1">个人中心</el-menu-item>
                <el-menu-item index="1000-2">消息通知</el-menu-item>
                <el-menu-item index="1000-3">账户设置</el-menu-item>
                <el-menu-item index="1000-4">退出登录</el-menu-item>
            </el-submenu>

            <el-menu-item index="1" class="title-selection">购物车</el-menu-item>
            <el-menu-item index="2" class="title-selection">我的订单</el-menu-item>
            <el-input placeholder="请输入内容" v-model="search_input" class="input-with-select">
                <el-button slot="append" icon="el-icon-search" v-on:click="handleSelect"></el-button>
            </el-input>
        </el-menu>
    </div>
    `
})

Vue.component('p_carousel', {
    template: ` 
    <div class="block">
        <el-carousel trigger="click" height="200px">
            <el-carousel-item v-for="item in 4" :key="item">
                <img src="./res/bg.jpg" />
            </el-carousel-item>
        </el-carousel>
    </div>
    `
})



Vue.component('s-identify', {
    props: {
        identifyCode: {
            type: String,
            default: '1234'
        },
        fontSizeMin: {
            type: Number,
            default: 16
        },
        fontSizeMax: {
            type: Number,
            default: 40
        },
        backgroundColorMin: {
            type: Number,
            default: 180
        },
        backgroundColorMax: {
            type: Number,
            default: 240
        },
        colorMin: {
            type: Number,
            default: 50
        },
        colorMax: {
            type: Number,
            default: 160
        },
        lineColorMin: {
            type: Number,
            default: 40
        },
        lineColorMax: {
            type: Number,
            default: 180
        },
        dotColorMin: {
            type: Number,
            default: 0
        },
        dotColorMax: {
            type: Number,
            default: 255
        },
        contentWidth: {
            type: Number,
            default: 112
        },
        contentHeight: {
            type: Number,
            default: 38
        }
    },
    methods: {
        // 生成一个随机数
        randomNum(min, max) {
            return Math.floor(Math.random() * (max - min) + min)
        },
        // 生成一个随机的颜色
        randomColor(min, max) {
            let r = this.randomNum(min, max)
            let g = this.randomNum(min, max)
            let b = this.randomNum(min, max)
            return 'rgb(' + r + ',' + g + ',' + b + ')'
        },
        drawPic() {
            let canvas = document.getElementById('s-canvas')
            let ctx = canvas.getContext('2d')
            ctx.textBaseline = 'bottom'
            // 绘制背景
            ctx.fillStyle = this.randomColor(this.backgroundColorMin, this.backgroundColorMax)
            ctx.fillRect(0, 0, this.contentWidth, this.contentHeight)
            // 绘制文字
            for (let i = 0; i < this.identifyCode.length; i++) {
                this.drawText(ctx, this.identifyCode[i], i)
            }
            this.drawLine(ctx)
            this.drawDot(ctx)
        },
        drawText(ctx, txt, i) {
            ctx.fillStyle = this.randomColor(this.colorMin, this.colorMax)
            ctx.font = this.randomNum(this.fontSizeMin, this.fontSizeMax) + 'px SimHei'
            let x = (i + 1) * (this.contentWidth / (this.identifyCode.length + 1))
            let y = this.randomNum(this.fontSizeMax, this.contentHeight - 5)
            var deg = this.randomNum(-45, 45)
            // 修改坐标原点和旋转角度
            ctx.translate(x, y)
            ctx.rotate(deg * Math.PI / 180)
            ctx.fillText(txt, 0, 0)
            // 恢复坐标原点和旋转角度
            ctx.rotate(-deg * Math.PI / 180)
            ctx.translate(-x, -y)
        },
        drawLine(ctx) {
            // 绘制干扰线
            for (let i = 0; i < 8; i++) {
                ctx.strokeStyle = this.randomColor(this.lineColorMin, this.lineColorMax)
                ctx.beginPath()
                ctx.moveTo(this.randomNum(0, this.contentWidth), this.randomNum(0, this.contentHeight))
                ctx.lineTo(this.randomNum(0, this.contentWidth), this.randomNum(0, this.contentHeight))
                ctx.stroke()
            }
        },
        drawDot(ctx) {
            // 绘制干扰点
            for (let i = 0; i < 100; i++) {
                ctx.fillStyle = this.randomColor(0, 255)
                ctx.beginPath()
                ctx.arc(this.randomNum(0, this.contentWidth), this.randomNum(0, this.contentHeight), 1, 0, 2 * Math.PI)
                ctx.fill()
            }
        }
    },
    watch: {
        identifyCode() {
            this.drawPic()
        }
    },
    mounted() {
        this.drawPic()
    },
    template: `
    <div class="s-canvas">
        <canvas id="s-canvas" :width="contentWidth" :height="contentHeight"></canvas>
    </div>    
    `
})