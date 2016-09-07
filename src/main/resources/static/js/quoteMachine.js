angular.module('quoteMachine', ['ngRoute'])
    .config(function($routeProvider){

        $routeProvider.when('/', {
            controller: 'quoteController',
            templateUrl: 'views/quote.html'
        });
        $routeProvider.otherwise('/');
    });