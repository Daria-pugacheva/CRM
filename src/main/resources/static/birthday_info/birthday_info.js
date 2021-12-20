angular.module('crm-front').controller('birthdayController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/crm/';

    $scope.loadCustomers = function () {
        $http ({
            url: contextPath + 'api/v1/customers/birthday',
            method: 'GET',
        }).then(function (response) {
            $scope.customers = response.data;
        });
    };

    $scope.createLetter = function (address,phone) {
        $http ({
            url: contextPath + 'api/v1/letters/' + address + '/'+ phone + '/BIRTH',
            method: 'GET',
        }).then(function (response) {
            $scope.letter = response.data;
        });
    };

    $scope.sendLetter = function () {
        $http ({
            url: contextPath + 'api/v1/letters/send',
            method: 'POST',
            data: $scope.letter
        }).then(function (response) {
            alert('Письмо успешно отправлено');
        });
    };

    $scope.loadCustomers();
});