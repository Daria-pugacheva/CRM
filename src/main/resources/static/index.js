(function () {
    angular
        .module('crm-front', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'welcome/welcome.html',
                controller: 'welcomeController'
            })
            .when('/birthday', {
                templateUrl: 'birthday_info/birthday_info.html',
                controller: 'birthdayController'
            })
            .when('/order', {
                templateUrl: 'order_info/order_info.html',
                controller: 'orderController'
            })
            .when('/product', {
                templateUrl: 'product_info/product_info.html',
                controller: 'productController'
            })
            // .when('/edit_product/:productId', {
            //     templateUrl: 'edit_product/edit_product.html',
            //     controller: 'editProductController'
            // })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http, $localStorage) {
        // const contextPath = 'http://localhost:8190/crm';
        // if ($localStorage.webMarketUser) {
        //     $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.webMarketUser.token;
        // }
        // if(!$localStorage.webMarketGuestCartId){
        //     $http.get(contextPath + '/api/v1/cart/generate')
        //         .then(function successCallback(response) {
        //             $localStorage.webMarketGuestCartId = response.data.value;
        //         });
        // }
    }
})();

angular.module('crm-front').controller('indexController', function ($rootScope, $scope, $http, $localStorage) {
    //const contextPath = 'http://localhost:8190/crm';

    // $scope.tryToAuth = function () {
    //     $http.post(contextPath + '/auth', $scope.user)
    //         .then(function successCallback(response) {
    //             if (response.data.token) {
    //                 $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
    //                 $localStorage.webMarketUser = {username: $scope.user.username, token: response.data.token};
    //
    //                 $scope.user.username = null;
    //                 $scope.user.password = null;
    //
    //                 $http.get(contextPath + '/api/v1/cart/' + $localStorage.webMarketGuestCartId + '/merge')
    //                     .then(function successCallback(response) {
    //                     });
    //             }
    //         }, function errorCallback(response) {
    //         });
    // };
    //
    // $scope.tryToLogout = function () {
    //     $scope.clearUser();
    //     if ($scope.user.username) {
    //         $scope.user.username = null;
    //     }
    //     if ($scope.user.password) {
    //         $scope.user.password = null;
    //     }
    //     $location.path('/');
    // };
    //
    // $scope.clearUser = function () {
    //     delete $localStorage.webMarketUser;
    //     $http.defaults.headers.common.Authorization = '';
    // };
    //
    // $rootScope.isUserLoggedIn = function () {
    //     if ($localStorage.webMarketUser) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    // };

});

