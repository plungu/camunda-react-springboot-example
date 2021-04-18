var path = require('path');
var webpack = require('webpack');
var Dotenv = require('dotenv-webpack');

module.exports = {
    entry: [
        'babel-polyfill',
	    'script!jquery/dist/jquery.min.js',
	    'script!foundation-sites/dist/foundation.min.js',
	    './src/main/js/reactjs/application/app.jsx'
	  ],
	externals: {
		jquery: 'jQuery'
	},
	plugins: [
	  new webpack.ProvidePlugin({
		  '$': 'jquery',
		  'jQuery': 'jquery'
	  }),
      new Dotenv()
    ],
    cache: false,
    debug: true,
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },
    resolve: {
        root: __dirname,
        alias: {
            Main: 'src/main/js/reactjs/application/components/Main.jsx',
            Nav: 'src/main/js/reactjs/application/components/Nav.jsx',
            IFrame: 'src/main/js/reactjs/application/components/IFrame.jsx',

            DisplayDate: 'src/main/js/reactjs/application/components/date/DisplayDate.jsx',
            DisplayDateTime: 'src/main/js/reactjs/application/components/date/DisplayDateTime.jsx',

            MarketingBar: 'src/main/js/reactjs/application/components/MarketingBar.jsx',
            StatusBar: 'src/main/js/reactjs/application/components/StatusBar.jsx',
            FooterBar: 'src/main/js/reactjs/application/components/FooterBar.jsx',

            Home: 'src/main/js/reactjs/application/components/home/Home.jsx',
            Detail: 'src/main/js/reactjs/application/components/home/Detail.jsx',
            StartForm: 'src/main/js/reactjs/application/components/home/StartForm.jsx',
            DetailForm: 'src/main/js/reactjs/application/components/home/DetailForm.jsx',
            Info: 'src/main/js/reactjs/application/components/home/Info.jsx',
            FilterBar: 'src/main/js/reactjs/application/components/home/FilterBar.jsx',
            ActionBar: 'src/main/js/reactjs/application/components/home/ActionBar.jsx',

            ItemHome: 'src/main/js/reactjs/application/components/item/Home.jsx',
            ItemLine: 'src/main/js/reactjs/application/components/item/Line.jsx',
            ItemList: 'src/main/js/reactjs/application/components/item/List.jsx',
            ItemDetail: 'src/main/js/reactjs/application/components/item/Detail.jsx',
            ItemForm: 'src/main/js/reactjs/application/components/item/Form.jsx',
            ItemInfo: 'src/main/js/reactjs/application/components/item/Info.jsx',
            ItemFilterBar: 'src/main/js/reactjs/application/components/item/FilterBar.jsx',
            ItemNavBar: 'src/main/js/reactjs/application/components/item/NavBar.jsx',
            ItemActionBar: 'src/main/js/reactjs/application/components/item/ActionBar.jsx',

            OrderHome: 'src/main/js/reactjs/application/components/order/Home.jsx',
            OrderLine: 'src/main/js/reactjs/application/components/order/Line.jsx',
            OrderList: 'src/main/js/reactjs/application/components/order/List.jsx',
            OrderDetail: 'src/main/js/reactjs/application/components/order/Detail.jsx',
            OrderForm: 'src/main/js/reactjs/application/components/order/Form.jsx',
            OrderInfo: 'src/main/js/reactjs/application/components/order/Info.jsx',
            OrderFilterBar: 'src/main/js/reactjs/application/components/order/FilterBar.jsx',
            OrderNavBar: 'src/main/js/reactjs/application/components/order/NavBar.jsx',
            OrderActionBar: 'src/main/js/reactjs/application/components/order/ActionBar.jsx',

            // Task: 'src/main/js/reactjs/application/components/task/Home.jsx',
            // TaskLine: 'src/main/js/reactjs/application/components/task/Line.jsx',
            // TaskList: 'src/main/js/reactjs/application/components/task/List.jsx',
            // TaskDetail: 'src/main/js/reactjs/application/components/task/Detail.jsx',
            // TaskForm: 'src/main/js/reactjs/application/components/task/Form.jsx',
            // TaskInfo: 'src/main/js/reactjs/application/components/task/Info.jsx',
            // TaskFilterBar: 'src/main/js/reactjs/application/components/task/FilterBar.jsx',
            // TaskNavBar: 'src/main/js/reactjs/application/components/task/NavBar.jsx',
            // TaskActionBar: 'src/main/js/reactjs/application/components/order/ActionBar.jsx',

            // TaskWorker: 'src/main/js/reactjs/application/components/task/worker/HomeWorker.jsx',
            // TaskLineWorker: 'src/main/js/reactjs/application/components/task/worker/LineWorker.jsx',
            // TaskListWorker: 'src/main/js/reactjs/application/components/task/worker/ListWorker.jsx',
            //
            // AssigneeFilterBar: 'src/main/js/reactjs/application/components/task/self-assign/AssigneeFilterBar.jsx',
            // ManagerReassignHome: 'src/main/js/reactjs/application/components/task/manager/ManagerReassignHome.jsx',
            // ManagerReassignLine: 'src/main/js/reactjs/application/components/task/manager/ManagerReassignLine.jsx',
            // ManagerReassignList: 'src/main/js/reactjs/application/components/task/manager/ManagerReassignList.jsx',
            // ManagerHome: 'src/main/js/reactjs/application/components/task/manager/ManagerHome.jsx',
            // ReassignActionBar: 'src/main/js/reactjs/application/components/task/manager/ReassignActionBar.jsx',

            UpdateNoteDialog: 'src/main/js/reactjs/application/components/note/UpdateNoteDialog.jsx',

            MessageLine: 'src/main/js/reactjs/application/components/message/MessageLine.jsx',
            MessageDetail: 'src/main/js/reactjs/application/components/message/MessageDetail.jsx',
            MessageList: 'src/main/js/reactjs/application/components/message/MessageList.jsx',
            MessageFilterBar: 'src/main/js/reactjs/application/components/message/MessageFilterBar.jsx',

            ContactMain: 'src/main/js/reactjs/application/components/contact/Home.jsx',
            ContactLine: 'src/main/js/reactjs/application/components/contact/Detail.jsx',
            ContactList: 'src/main/js/reactjs/application/components/contact/DetailForm.jsx',
            ContactDetail: 'src/main/js/reactjs/application/components/contact/FilterBar.jsx',
            ContactFilterBar: 'src/main/js/reactjs/application/components/contact/info.jsx',

            uriListConverter: 'src/main/js/api/uriListConverter.js',
            uriTemplateInterceptor: 'src/main/js/api/uriTemplateInterceptor.js',
            applicaitonStyles: 'src/main/resources/static/app.css'
        },
        extensions: ['', '.js', '.jsx']
    },
    module: {
        loaders: [
            {
                loader: 'babel-loader',
                query: {
                    cacheDirectory: false,
                    presets: ['es2015', 'react', 'stage-0']
                },
                test: path.join(__dirname, '.'),
                exclude: /(node_modules|bower_components)/,
            },
            {loaders: ['style', 'css', 'sass'], test: /\.scss$/ }
        ]
    },
    devtool: ['cheap-module-source-map', 'sourcemaps']
};
