angular.module('crm-front').controller('productController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:8190/crm/';

    $scope.loadCustomers = function (product_id) {
        $http ({
            url: contextPath + 'api/v1/customers/' + product_id,
            method: 'GET'
        }).then(function (response) {
            $scope.customers = response.data;
        });
    };

    $scope.createBonusLetter = function (address) {
        $http ({
            url: contextPath + 'api/v1/letters/' + address + '/BONUS',
            method: 'GET',
        }).then(function (response) {
            $scope.bonusletter = response.data;
        });
    };


});