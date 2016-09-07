angular.module('quoteMachine')
    .factory('QuoteService', ['$http', function($http) {

        var quoteService = (function() {
            return {
                get: function(url, success) {
                    $http({
                        method: 'GET',
                        url: url
                    }).success(function(resp, status) {
                        success(resp, status);
                    }).error(function(err, status) {
                        console.log(err);
                    });
                }
            };
        })();

        var app = {
            quotes: (function() {
                return {
                    findOne: function(success) {
                        quoteService.get('/quotes', success);
                    }
                };
            })()
        };

        return app;

    }]);