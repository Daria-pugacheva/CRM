angular.module('crm-front').controller('orderController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/crm/';

    $scope.loadOrders = function (min_price) {
        $http ({
                url: contextPath + 'api/v1/orders/' + min_price,
                method: 'GET'
            }).then(function (response) {
                $scope.orders = response.data;
            });
        };


});