console.log("Application Started :D");

/**
 * Utilitary to 
 * 
 * @param {String} url
 * @param {Object} customParam
 * @returns {Object}
 */
var Ajax = function (url, customParam) {

    // Validates the URL
    if (!url)
        throw 'URL Must be valid!';

    // Some default parameters
    var param = $.extend({
        method: 'GET',
        data: {}
    }, customParam);

    /**
     * Sends a request and returns a promise
     * 
     * @returns {Promise}
     */
    function send() {
        var q = $.Deferred();
        $.ajax({
            url: encodeURI(url),
            method: param.method,
            data: param.data,
            success: (response) => q.resolve(response),
            error: (response) => q.reject(response)
        });
        return q.promise();
    }

    function post() {
        param.method = 'POST';
        return send();
    }

    function get() {
        param.method = 'GET';
        return send();
    }

    return {
        send: send,
        post: post,
        get: get
    };

};