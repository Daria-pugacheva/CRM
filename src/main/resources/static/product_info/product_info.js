angular.module('crm-front').controller('productController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:8190/crm/';

    $scope.loadCustomers = function (product_id) {
        $http ({
            url: contextPath + 'api/v1/customers/' + product_id,
            method: 'GET'
        }).then(function (response) {
            $scope.customers = response.data;
            $scope.current_product_id = product_id;
        });
    };

    $scope.createBonusLetter = function (address,phone) {
        $http ({
            url: contextPath + 'api/v1/letters/' + address + '/'+ phone + '/BONUS',
            method: 'GET',
        }).then(function (response) {
            $scope.bonusletter = response.data;
        });
    };

    $scope.sendBonusLetter = function () {
        $http ({
            url: contextPath + 'api/v1/letters/send',
            method: 'POST',
            data: $scope.bonusletter
        }).then(function (response) {
            alert('Письмо успешно отправлено');
        });
    };

    $scope.makeProductReport = function () {
        $http ({
            url: contextPath + 'api/v1/customers/report/'+ $scope.name +'/BONUS/' + $scope.current_product_id,
            method: 'POST',
            data: $scope.customers
        }).then(function (response) {
            alert('Отчет создан');
        });
    };



});