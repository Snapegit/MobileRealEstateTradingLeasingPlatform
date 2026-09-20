	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import discussfangyuanchushou from '@/views/discussfangyuanchushou/list'
	import news from '@/views/news/list'
	import fangwuleixing from '@/views/fangwuleixing/list'
	import fangyuanchuzu from '@/views/fangyuanchuzu/list'
	import yudingfangzi from '@/views/yudingfangzi/list'
	import yuyuegoufang from '@/views/yuyuegoufang/list'
	import yuyuezufang from '@/views/yuyuezufang/list'
	import storeup from '@/views/storeup/list'
	import jingjiren from '@/views/jingjiren/list'
	import fangyuanchushou from '@/views/fangyuanchushou/list'
	import discussfangyuanchuzu from '@/views/discussfangyuanchuzu/list'
	import mendian from '@/views/mendian/list'
	import yonghu from '@/views/yonghu/list'
	import config from '@/views/config/list'
	import zufangxinxi from '@/views/zufangxinxi/list'
	import jingjirenRegister from '@/views/jingjiren/register'
	import jingjirenCenter from '@/views/jingjiren/center'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页Home',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/jingjirenCenter',
			name: '经纪人个人中心',
			component: jingjirenCenter
		}
		,{
			path: '/discussfangyuanchushou',
			name: '房源出售评论',
			component: discussfangyuanchushou
		}
		,{
			path: '/news',
			name: '新闻资讯',
			component: news
		}
		,{
			path: '/fangwuleixing',
			name: '房屋类型',
			component: fangwuleixing
		}
		,{
			path: '/fangyuanchuzu',
			name: '房源出租',
			component: fangyuanchuzu
		}
		,{
			path: '/yudingfangzi',
			name: '预定房子',
			component: yudingfangzi
		}
		,{
			path: '/yuyuegoufang',
			name: '预约购房',
			component: yuyuegoufang
		}
		,{
			path: '/yuyuezufang',
			name: '预约租房',
			component: yuyuezufang
		}
		,{
			path: '/storeup',
			name: '我的收藏',
			component: storeup
		}
		,{
			path: '/jingjiren',
			name: '经纪人',
			component: jingjiren
		}
		,{
			path: '/fangyuanchushou',
			name: '房源出售',
			component: fangyuanchushou
		}
		,{
			path: '/discussfangyuanchuzu',
			name: '房源出租评论',
			component: discussfangyuanchuzu
		}
		,{
			path: '/mendian',
			name: '门店',
			component: mendian
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		,{
			path: '/zufangxinxi',
			name: '租房信息',
			component: zufangxinxi
		}
		]
	},
	{
		path: '/jingjirenRegister',
		name: '经纪人注册',
		component: jingjirenRegister
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
