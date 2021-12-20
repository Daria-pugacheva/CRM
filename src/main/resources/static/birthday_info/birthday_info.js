angular.module('crm-front').controller('birthdayController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/crm/';

    $scope.loadCustomers = function () {
            $http ({
                url: contextPath + 'api/v1/customers/birthday',
                method: 'GET',
            }).then(function (response) {
               // console.log(response);
                $scope.customers = response.data;
            });
        };

    $scope.createLetter = function (address) {
        $http ({
            url: contextPath + 'api/v1/letters/' + address + '/BIRTH',
            method: 'GET',
        }).then(function (response) {
            $scope.letter = response.data;
        });
    };

    $scope.loadCustomers();
});